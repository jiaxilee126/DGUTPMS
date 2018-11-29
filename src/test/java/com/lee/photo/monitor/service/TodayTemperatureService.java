package com.lee.photo.monitor.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ������ſȡ��ҳ�ϵĽ��������
 * @author     zjm    
 * @time     2014/8/6
 */
public class TodayTemperatureService {
    
     /** 
     * ����http get�����ȡ��ҳԴ���� 
     * @param requestUrl     String    �����ַ
     * @return                 String    �õ�ַ���ص�html�ַ���
     */  
    private static String httpRequest(String requestUrl) {  
        
        StringBuffer buffer = null;  
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        InputStream inputStream = null;
        HttpURLConnection httpUrlConn = null;
  
        try {  
            // ����get����
            URL url = new URL(requestUrl);  
            httpUrlConn = (HttpURLConnection) url.openConnection();  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setRequestMethod("GET");  
  
            // ��ȡ������  
            inputStream = httpUrlConn.getInputStream();  
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            bufferedReader = new BufferedReader(inputStreamReader);  
  
            // ����������ȡ���
            buffer = new StringBuffer();  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  finally {
            // �ͷ���Դ
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpUrlConn != null){
                httpUrlConn.disconnect();  
            }
        }
        return buffer.toString();  
    }  
  
    /** 
     * ���˵�html�ַ��������õ���Ϣ
     * @param html    String    html�ַ���
     * @return         String    ���õ�����
     */ 
    private static String htmlFiter(String html) {  
        
        StringBuffer buffer = new StringBuffer();  
        String str1 = "";
        String str2 = "";
        buffer.append("����:");
        
        // ȡ�����õķ�Χ
        Pattern p = Pattern.compile("(.*)(<li class=\'dn on\' data-dn=\'7d1\'>)(.*?)(</li>)(.*)");  
        Matcher m = p.matcher(html);  
        if (m.matches()) {  
            str1 = m.group(3);
            // ƥ�����ڣ�ע�����ڱ�������<h2> �� </h2>��
            p = Pattern.compile("(.*)(<h2>)(.*?)(</h2>)(.*)");
            m = p.matcher(str1);
            if(m.matches()){
                str2 = m.group(3);
                buffer.append(str2);
                buffer.append("\n������");
            }
            // ƥ��������ע��������������<p class="wea" title="..."> �� </p>��
            p = Pattern.compile("(.*)(<p class=\"wea\" title=)(.*?)(>)(.*?)(</p>)(.*)");
            m = p.matcher(str1);
            if(m.matches()){
                str2 = m.group(5);
                buffer.append(str2);
                buffer.append("\n�¶ȣ�");
            }
            // ƥ���¶ȣ�ע���¶ȱ�������<p class=\"tem tem2\"> <span> �� </span><i>��
            p = Pattern.compile("(.*)(<p class=\"tem tem2\"> <span>)(.*?)(</span><i>)(.*)");
            m = p.matcher(str1);
            if(m.matches()){
                str2 = m.group(3);
                buffer.append(str2);
                buffer.append("��~");
            }
            p = Pattern.compile("(.*)(<p class=\"tem tem1\"> <span>)(.*?)(</span><i>)(.*)");
            m = p.matcher(str1);
            if(m.matches()){
                str2 = m.group(3);
                buffer.append(str2);
                buffer.append("��\n������");
            }
            // ƥ��磬ע��<i> �� </i> ��
            p = Pattern.compile("(.*)(<i>)(.*?)(</i>)(.*)");
            m = p.matcher(str1);
            if(m.matches()){
                str2 = m.group(3);
                buffer.append(str2);
            }
        }  
        return buffer.toString();
    }
    
    /** 
     *  �����������������з�װ��
     * @return 
     */  
    public static String getTodayTemperatureInfo() {  
        // ���õ�һ����������ȡhtml�ַ���
        String monthDATA = httpRequest("http://10.208.127.16/nep/static/local/0_month/?"+System.currentTimeMillis());  
        // ���õڶ������������˵����õ���Ϣ
        System.out.println(monthDATA);
        String dayData = httpRequest("http://10.208.127.16/nep/static/local/0_detail/?"+System.currentTimeMillis());
        System.out.println(dayData);
        String realData = httpRequest("http://10.208.127.16/nep/realdata/tt/0/"+System.currentTimeMillis());
        System.out.println(realData);// td �ǽ��շ�����  tt���ܷ�����   1.08 ��ϵ��
        //��λ�ֱ���KWH KWH  ����1000֮���ֵ
        
        // String result = htmlFiter(html);  
        String result = "";
        return result;  
    }  
  
    /**
     * ����
     * @param args
     */
    public static void main(String[] args) {  
        String info = getTodayTemperatureInfo();
        System.out.println(info);
    }  
}