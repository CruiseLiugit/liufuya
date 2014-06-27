package com.seaway.liufuya;

import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Localization;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

/*
 * 注解
 * <li>通过 '@Modules' 注解声明整个应用有哪些模块，scanPackage 自动扫描指定包
 * <li>通过 '@IocBy' 注解声明整个应用，应采用何种方式进行反转注入。如果没有声明，整个应用将不支持 Ioc
 * <li>通过 '@SetupBy' 注解声明应用启动的关闭时，应该进行的处理。（通过 Setup 接口）
 * <li>通过 '@Ok' 注解声明整个应用默认的成功视图, json 会把结果转化为 json 返回，raw 原样返回
 * <li>通过 '@Fail' 注解声明整个应用默认的失败视图
 */
@Modules(scanPackage=true)
@Ok("json")
@Fail("json")
@IocBy(type=ComboIocProvider.class,args={
	"*org.nutz.ioc.loader.json.JsonLoader","ioc/",
	"*org.nutz.ioc.loader.annotation.AnnotationIocLoader","com.seaway.liufuya"
})
//全局的字符过滤器
@SetupBy(value=CoreSetup.class)
@Encoding(input="UTF-8",output="UTF-8")
public class MainModule {

}