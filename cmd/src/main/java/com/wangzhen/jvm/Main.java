package com.wangzhen.jvm;

import org.apache.commons.cli.*;

import java.util.Arrays;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // https://blog.csdn.net/yamaxifeng_132/article/details/87822812
        Options options = new Options();
        options.addOption("h", "help", false, "打印帮助信息");
        options.addOption("v", "version", false, "显示当前jdk 版本");
        options.addOption("jar",true,"执行一个jar");
        CommandLineParser parser = new PosixParser();
        try {
            CommandLine cli = parser.parse(options, args);
            if (cli.hasOption("h")){
                HelpFormatter hf = new HelpFormatter();
                hf.printHelp("Options", options);
                //System.out.println("这是jvmOnJava的帮助信息!");
            }else if(cli.hasOption("v")){
                System.out.println("jdk1.8");
            }else {
                if(cli.hasOption("jar")){
                    String []jarParameters = cli.getOptionValues("jar");
                    System.out.println(Arrays.asList(jarParameters));
                }
//                String database = cli.getOptionValue("d");
//                System.out.println("database: " + database);
//                String table = cli.getOptionValue("t");
//                System.out.println("table: " + table);
//                String[] files = cli.getOptionValues("f");
//                System.out.println("files: " + Arrays.asList(files));
//                Properties properties = cli.getOptionProperties("D");
//                String ext = properties.getProperty("ext");
//                System.out.println("property ext = " + ext);
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
