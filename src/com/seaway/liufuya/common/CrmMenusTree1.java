package com.seaway.liufuya.common;

/**
 * 会员管理
 * PanelCRM.java 中需要使用的菜单项目
 * @author lililiu
 *
 *{"会员资料","扩展资料","会员等级","会员活动","会员黑名单","会员诉求","诉求类别","短信发送"};
 *public static void main(String args[])  
{  
        // Color colors=new Color(100,200,300);  //wrong  
           Color color=Color.RED;  
           System.out.println(color);  // 调用了toString()方法  
}    
 */
public enum CrmMenusTree1 {
	 MEMBER_INFO1("会员资料"),MEMBER_INFO2("扩展资料"),MEMBER_INFO3("会员等级"),MEMBER_INFO4("会员活动"),MEMBER_INFO5("会员黑名单"),MEMBER_INFO6("会员诉求"),MEMBER_INFO7("诉求类别"),MEMBER_INFO8("短信发送");  
     //构造枚举值，比如RED(255,0,0)  
     private CrmMenusTree1(String tp){  
      this.type=tp;  
     }  

     public String toString(){  //覆盖了父类Enum的toString()  
     return super.toString()+type;  
     }  

     private String type;  //自定义数据域，private为了封装。
}
