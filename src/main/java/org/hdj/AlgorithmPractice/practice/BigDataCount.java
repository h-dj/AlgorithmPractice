package org.hdj.AlgorithmPractice.practice;

import java.io.*;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description: 大数据量统计
 * 1、手写代码，在10亿的商品日志中找出出现最多的一百个商品
 * 要求：
 * 内存： 100M
 * @Author huangjiajian
 * @Date 2022/12/28 9:43
 */
public class BigDataCount {


    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) throws IOException {
        Path dir = Paths.get(System.getProperty("user.home"), "split");
        Path productLogFile = Paths.get(System.getProperty("user.home"), "split", "product.log");
        //生成日志
        //generateLog(dir,productLogFile);
        //hash 分割文件
        //splitHash(productLogFile);
        //使用堆找到topK
        List<Path> list = Files.list(dir)
                .filter(f -> {
                    System.out.println(f.toFile().getName());
                    return f.toFile().getName().startsWith("商品-hash-");
                }).collect(Collectors.toList());

        for (Path path : list) {
            countTopK(path,100);
        }
        //归并



    }

    private static void countTopK(Path path, int K) throws IOException {
        final HashMap<String, Integer> count=new HashMap<>();
        PriorityQueue<String> top100 = new PriorityQueue<>(10, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return count.get(o2)-count.get(o1);
            }
        });

        BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        Stream<String> lines = bufferedReader.lines();

        lines
                .forEach(f->{
                    String name = f.split(",")[1];
                    count.put(name,count.getOrDefault(name,0)+1);
                });


        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            int size = top100.size();
            if(size <10){
                top100.offer(entry.getKey());
            }else {
                top100.poll();
                top100.offer(entry.getKey());
            }
        }

        List<String> list=new ArrayList<>(10);
        while (!top100.isEmpty()){
            try {
                String name = top100.poll();
                String text = String.format("%s %d",name,count.get(name));
                list.add(text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Path resolve = Paths.get(System.getProperty("user.home"), "topK-heap", path.toFile().getName());
        resolve.getParent().toFile().mkdirs();
        Files.write(resolve, list, StandardOpenOption.CREATE);

    }


    /**
     * 读取文件，按照商品名称hash 分桶
     *
     * @param file
     */
    public static void splitHash(Path file) throws IOException {
        //对10亿的商品日志求hash值，hash值对1024求余，将商品分到1024个文件中，
        // 在每个文件中利用长度100的大顶堆找到前100的商品，
        // 再将1024个文件找出的1024*100的商品用大顶堆遍历找到前100个

        long start = System.currentTimeMillis();
        ExecutorService executorService = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(2048));
        HashMap<Integer, ArrayList<String>> cache = new HashMap<>();
        BufferedReader bufferedReader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
        bufferedReader.lines()
                .forEach(f -> {
                    try {
                        String name = f.split(",")[1];
                        Integer hash = (Math.abs(hash(name)) % 2048);

                        cache.putIfAbsent(hash, new ArrayList<>(1000));
                        int size = cache.get(hash).size();
                        if (size >= 1000) {
                            ArrayList<String> list = new ArrayList<>(cache.get(hash));
                            cache.get(hash).clear();
                            executorService.execute(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Integer tag = hash;
                                        Path resolve = Paths.get(file.getParent().toString(), "商品-hash-" + tag + ".log");
                                        if (resolve.toFile().exists()) {
                                            Files.write(resolve, list, StandardOpenOption.APPEND);
                                        } else {
                                            Files.write(resolve, list, StandardOpenOption.CREATE);
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                }
                            });
                        } else {
                            cache.get(hash).add(f);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        executorService.shutdown();
        long end = (System.currentTimeMillis() - start)/1000;
        System.out.println("耗时"+end+"秒");

    }


    /**
     * 把多个文件合并为一个文件
     *
     * @param file       目标文件
     * @param chunkFiles 分片文件
     */
    public static void mergeFile(Path file, Path... chunkFiles) throws IOException {
        if (chunkFiles == null || chunkFiles.length == 0) {
            throw new IllegalArgumentException("分片文件不能为空");
        }

        boolean exists = file.toFile().exists();
        EnumSet<StandardOpenOption> enumSet = EnumSet.of(StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
        if (exists) {
            enumSet = EnumSet.of(StandardOpenOption.APPEND);
        }

        try (FileChannel fileChannel = FileChannel.open(file, enumSet)) {
            for (Path chunkFile : chunkFiles) {
                try (FileChannel chunkChannel = FileChannel.open(chunkFile, EnumSet.of(StandardOpenOption.READ))) {
                    chunkChannel.transferTo(0, chunkChannel.size(), fileChannel);
                }
            }
        }
    }

    public static void generateLog(Path dir, Path productLogFile) {
        long numCount = 10 * 10000 * 10000;
        int num = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        System.out.println("生成路径：" + dir.toString());


        final CyclicBarrier barrier = new CyclicBarrier(num, new Runnable() {
            long startTime = System.currentTimeMillis();

            @Override
            public void run() {
                //合并文件
                try {
                    List<Path> list = Files.list(dir)
                            .filter(f -> {
                                System.out.println(f.toFile().getName());
                                return f.toFile().getName().matches("product-\\d+-\\d+\\.log");
                            }).collect(Collectors.toList());


                    mergeFile(productLogFile, list.toArray(new Path[list.size()]));

                    list.forEach(f -> {
                        try {
                            Files.deleteIfExists(f);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

                    long endTime = System.currentTimeMillis();
                    System.out.println((endTime - startTime) / 1000 + "秒");
                    startTime = System.currentTimeMillis();

                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        });

        int startIndex = 0;
        int endIndex = 1000 * 10000;
        int i = 0;
        while (endIndex <= numCount) {
            executorService.execute(new GeneratorThread(startIndex, endIndex, barrier));
            startIndex = endIndex;
            endIndex = endIndex + 1000 * 10000;
            System.out.println(++i);
        }
        executorService.shutdown();
    }

    static class GeneratorThread implements Runnable {

        String logFormat = "thread-%s , %s , %s";
        Path path;
        int startIndex;
        int endIndex;

        CyclicBarrier barrier;

        public GeneratorThread(int startIndex, int endIndex, CyclicBarrier barrier) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.barrier = barrier;

            this.path = Paths.get(System.getProperty("user.home"), "split", "product-" + startIndex + "-" + endIndex + ".log");
        }

        @Override
        public void run() {
            LinkedList<String> list = new LinkedList<>();
            for (int i = startIndex; i < endIndex; i++) {
                int index = new Random().nextInt(10000);
                String format = String.format(logFormat, Thread.currentThread().getId(), "商品-" + index, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
                list.add(format);
                if (list.size() >= 10000) {
                    try {
                        if (path.toFile().exists()) {
                            Files.write(path, list, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                        } else {
                            path.getParent().toFile().mkdirs();
                            Files.write(path, list, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    list.clear();
                }
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
