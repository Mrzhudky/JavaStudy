package com.company;

import java.util.Scanner;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import javax.xml.bind.SchemaOutputResolver;


public class Main {

    public static void mergePdfFiles(String[] srcFile, String destFile) {
        boolean retValue = false;
        PdfDocument pdf = null;
        try {
                PdfWriter writer = new PdfWriter(destFile);
                pdf = new PdfDocument(writer);
                for (int i = 0; i < srcFile.length; i++) {
                    PdfDocument origPdf = new PdfDocument(new PdfReader(srcFile[i]));
                    int n = origPdf.getNumberOfPages();
                    for (int j = 1; j <= n; j++) {
                        PdfPage page = origPdf.getPage(j);
                        pdf.addPage(page.copyTo(pdf));
                    }
                    origPdf.close();
                }
            retValue = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pdf.close();
            if(retValue){
                System.out.println("合并成功！");
            }else{
                System.out.println("合并失败！");
            }
        }
    }
    public static void main(String[] args) {
	// write your code here

        System.out.println("请输入需合并的文件数：");
        Scanner sc = new Scanner(System.in);
        int fileNum = 0;

        fileNum = sc.nextInt();

        sc.nextLine();
        System.out.println("请输入需合并的文件：");
        String[] files = new String[fileNum];
        for (int i = 0; i < fileNum; i++) {
            String str = sc.nextLine();
            files[i] = str;
        }
        System.out.println("请输入输出文件名：");
        String savepath = sc.nextLine();
        mergePdfFiles(files, savepath);

    }
}
