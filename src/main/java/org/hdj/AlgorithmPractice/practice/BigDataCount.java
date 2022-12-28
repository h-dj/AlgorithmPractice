package org.hdj.AlgorithmPractice.practice;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/**
 * @Description: 大数据量统计
 * 1、手写代码，在10亿的商品日志中找出出现最多的一百个商品
 * @Author huangjiajian
 * @Date 2022/12/28 9:43
 */
public class BigDataCount {

    static Path path = Paths.get(System.getProperty("user.dir"), "product.log");
    static Path bigdataCountDir = Paths.get(System.getProperty("user.dir"), "bigdataCount");

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) throws IOException {
        //generateLog();//
        //对10亿的商品日志求hash值，hash值对1024求余，将商品分到1024个文件中，
        // 在每个文件中利用长度100的大顶堆找到前100的商品，
        // 再将1024个文件找出的1024*100的商品用大顶堆遍历找到前100个

        BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        bufferedReader.lines()
                .forEach(f -> {
                    try {
                        String name = f.split(",")[1];
                        Path resolve = Paths.get(bigdataCountDir.toString(),"商品-" + (hash(name) % 1024) + ".log");
                        if (resolve.toFile().exists()) {
                            CharsetEncoder encoder = StandardCharsets.UTF_8.newEncoder();
                            try (OutputStream out = Files.newOutputStream(resolve, StandardOpenOption.APPEND);
                                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, encoder))) {
                                writer.append(f);
                                writer.newLine();
                            }
                        } else {
                            bigdataCountDir.toFile().mkdirs();
                            CharsetEncoder encoder = StandardCharsets.UTF_8.newEncoder();
                            try (OutputStream out = Files.newOutputStream(resolve, StandardOpenOption.CREATE);
                                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, encoder))) {
                                writer.append(f);
                                writer.newLine();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });


    }

    public static void generateLog() {
        String logFormat = "thread-%s , %s , %s";
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        AtomicLong atomicLong = new AtomicLong(1);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                LinkedList<String> list = new LinkedList<>();
                while (atomicLong.incrementAndGet() < 10 * 10000 * 10000) {
                    int index = new Random().nextInt(10000);
                    String format = String.format(logFormat, Thread.currentThread().getName(), "商品-" + index, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
                    list.add(format);
                    if (list.size() >= 10000) {
                        try {
                            if (path.toFile().exists()) {
                                Files.write(path, list, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                            } else {
                                Files.write(path, list, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        list.clear();
                    }
                }
            }
        });
        executorService.shutdown();

    }
}
