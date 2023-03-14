package org.example.util;

import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class ScannerUtil {
    public static Scanner StringScanner= new Scanner(System.in);
    public static Scanner IntScanner= new Scanner(System.in);
    public static Scanner LocalDateScanner=new Scanner(System.in);
}
