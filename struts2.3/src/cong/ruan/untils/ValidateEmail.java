package cong.ruan.untils;


public class ValidateEmail
{
	private static final String EMAIL_ADDRESS_PATTERN =	"\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b";
	public static boolean isEmail(String email)
	{
			return email.matches(EMAIL_ADDRESS_PATTERN);
	}
	
	public static void main(String[] args)
	{
		System.out.println(isEmail("1308811723@qq"));
	}
}
