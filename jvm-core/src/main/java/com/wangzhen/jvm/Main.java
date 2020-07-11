package com.wangzhen.jvm;

import com.wangzhen.jvm.classPackage.ClassFile;
import org.apache.commons.cli.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // https://blog.csdn.net/yamaxifeng_132/article/details/87822812
        Options options = new Options();
        options.addOption("h", "help", false, "打印帮助信息");
        options.addOption("v", "version", false, "显示当前jdk 版本");
        options.addOption("jar",true,"执行一个jar");
        //options.addOption("cp","classpath",true,"指定类路径");
        Option cpOption = OptionBuilder
                .withArgName("args")
                .withLongOpt("classpath")
                .hasArgs()
                .withDescription("制定类路径")
                .create("cp");
        options.addOption(cpOption);

        CommandLineParser parser = new PosixParser();
        try {
            CommandLine cli = parser.parse(options, args);
            if (cli.hasOption("h")){
                HelpFormatter hf = new HelpFormatter();
                hf.printHelp("Options", options);
                //System.out.println("这是jvmOnJava的帮助信息!");
            }
            if(cli.hasOption("v")){
                System.out.println("jdk1.8");
            }
            if(cli.hasOption("jar")){
                String []jarParameters = cli.getOptionValues("jar");
                System.out.println(Arrays.asList(jarParameters));
            }

            // java -jar jvm.jar -cp classes/com/wangzhen/jvm/ App.class
            // -cp cmd/target/classes/com/wangzhen/jvm App.class
            if(cli.hasOption("cp")){
                String []cpParameters = cli.getOptionValues("cp");
                DirEntry dirEntry = new DirEntry(cpParameters[0]);
                byte [] classFileData = dirEntry.readClass(cpParameters[1]);
                ClassFile classFile = new ClassFile(classFileData);
                System.out.println(classFile.toString());
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
