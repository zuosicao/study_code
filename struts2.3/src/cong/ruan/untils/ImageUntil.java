package cong.ruan.untils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 四位随机数字验证码生成工具
 * @author SB
 *
 */
public class ImageUntil
{
	private static int IMAGE_WIDTH = 200;//图片宽度 
	private static int IMAGE_HEIGHT = 60;//图片长度
	private static int POINT_COUNTS = 200;//干扰点的数量
	private static int FONT_SIZE = 40;//图片上的字体大小
	private static Random random = new Random();//用于产生随机数
	
	/**
	 * 生成验证码图片
	 * @return 返回一个Map对象，key是验证码的具体值，value为这个验证码图片字符流，封装在一个输入流中
	 * @throws ImageFormatException
	 * @throws IOException
	 */
	public static Map<String,InputStream> createImage()
	{
		BufferedImage bufferedImage = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.getGraphics();
		
		StringBuffer buffer = new StringBuffer();//用来存储验证码字符串
		
		//填充背景色
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
		
		graphics.setFont(new Font(null, Font.BOLD, FONT_SIZE));
		
		//画验4位证码
		for (int i = 0; i < 4; i++)
		{
			graphics.setColor(getRandomColor());
			String temp = String.valueOf(random.nextInt(10));
			buffer.append(temp);
			graphics.drawString(temp, 40*i + 20, 30 + random.nextInt(25));
		}
		//System.out.println(buffer.toString());
		
		//画干扰点
		graphics.setFont(new Font(null, Font.BOLD,30));
		for (int i = 0 ; i < POINT_COUNTS; i ++)
		{
			graphics.setColor(getRandomColor());
			graphics.drawString(".", random.nextInt(290), random.nextInt(90));
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JPEGImageEncoder endoder = JPEGCodec.createJPEGEncoder(baos);
		try
		{
			endoder.encode(bufferedImage);
		} catch (ImageFormatException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		Map<String,InputStream> result = new HashMap<String,InputStream>();
		result.put(buffer.toString(), bais);
		return result;
		
//		FileOutputStream file = new FileOutputStream("c:/1.jpg");
//		file.write(baos.toByteArray());
//		file.close();
//		baos.close();
//		System.out.println("done!!");
	}
	public static void main(String[] args)
	{
		createImage();
	}
	
	/**
	 * 得到随机颜色
	 * @return
	 */
	private static Color getRandomColor()
	{
		return new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
	}
}
