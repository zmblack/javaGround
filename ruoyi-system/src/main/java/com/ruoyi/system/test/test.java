package com.ruoyi.system.test;

import com.ruoyi.common.utils.spring.SpringUtils;
import org.python.core.PyString;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class test {

    public static void main(String[] args) throws IOException, InterruptedException {

//        PythonInterpreter interpreter = new PythonInterpreter();
//        //我在这里使用相对路径，注意区分
//
//        interpreter.execfile("D:\\project\\spingboot\\RuoYi-Vue-Plus\\ruoyi-system\\src\\main\\java\\com\\ruoyi\\system\\test\\read.py");

        Process proc;
        try {
            proc = Runtime.getRuntime().exec("E:\\sofoPath\\anaconda\\envs\\project\\python.exe D:\\project\\spingboot\\RuoYi-Vue-Plus\\ruoyi-system\\src\\main\\java\\com\\ruoyi\\system\\test\\read.py");// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(),"gb2312"));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
