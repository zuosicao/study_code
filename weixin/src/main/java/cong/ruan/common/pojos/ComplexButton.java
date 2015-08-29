package cong.ruan.common.pojos;

/**
 * 复合按钮，含有二级菜单
 * @author RuanCong
 * @time 2014-4-28 下午2:59:15
 */
public class ComplexButton extends Button
{
	private Button[] sub_button;

	public Button[] getSub_button()
	{
		return sub_button;
	}

	public void setSub_button(Button[] sub_button)
	{
		this.sub_button = sub_button;
	}
}
