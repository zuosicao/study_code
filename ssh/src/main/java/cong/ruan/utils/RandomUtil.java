package cong.ruan.utils;

import java.util.Random;
import java.util.UUID;

public class RandomUtil
{
	public static String createUUID()
	{
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	/**
	 * 产生随机字符串
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length)
	{ //length表示生成字符串的长度
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++)
	    {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 } 
	
	/**
	 * 产生随机文件名（不含有后缀名）
	 * @param length
	 * @return
	 */
	public static String randomFileName()
	{ 
		return System.currentTimeMillis() + getRandomString(6);
	} 
	
	/**
	 * 产生随机数字字符串
	 * @param length
	 * @return
	 */
	public static String getRandomDigitString(int length)
	{ //length表示生成字符串的长度
	    String base = "0123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++)
	    {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 }  
	
	/**
	 * 得到不大于 baseNum的随机数
	 * @param baseNum
	 * @return
	 */
	public static int getRandomNum(int baseNum)
	{
		Random random = new Random(); 
		
		return random.nextInt(baseNum);
	}
	public static void main(String[] args)
	{
		System.out.println(createUUID());
	}
}
