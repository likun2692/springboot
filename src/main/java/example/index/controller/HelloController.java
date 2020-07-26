package example.index.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@Controller
public class HelloController {
    public static Map<String,Object> map=new HashMap<>();

    @RequestMapping(value="/info",method=RequestMethod.GET)
    public String index(@RequestHeader Map<String, String> headers) throws  UnknownHostException {
        long  startTime = System.currentTimeMillis();
        map=new HashMap<>();
        headers.forEach((key, value) -> {
            // 日志中输出所有请求头
            map.put("Header----"+key,value);
            System.out.println(String.format("Header '%s' = %s", key, value));
        });
        //获取计算机各个指标
        Runtime r = Runtime.getRuntime();
        Properties props = System.getProperties();
        InetAddress addr;
        addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress();
        Map<String, String> map1 = System.getenv();
        String userName = map1.get("USERNAME");// 获取用户名
        String computerName = map1.get("COMPUTERNAME");// 获取计算机名
        String userDomain = map1.get("USERDOMAIN");// 获取计算机域名
        map.put("zb-用户名:    " , userName);
        map.put("zb-计算机名:    " , computerName);
        map.put("zb-计算机域名:    " , userDomain);
        map.put("zb-本地ip地址:    " , ip);
        map.put("zb-本地主机名:    " , addr.getHostName());
        map.put("zb-JVM可以使用的总内存:    " , r.totalMemory());
        map.put("zb-JVM可以使用的剩余内存:    " , r.freeMemory());
        map.put("zb-JVM可以使用的处理器个数:    " , r.availableProcessors());
        map.put("zb-Java的运行环境版本：    " , props.getProperty("java.version"));
        map.put("zb-Java的运行环境供应商：    " , props.getProperty("java.vendor"));
        map.put("zb-Java供应商的URL：    " , props.getProperty("java.vendor.url"));
        map.put("zb-Java的安装路径：    " , props.getProperty("java.home"));
        map.put("zb-Java的虚拟机规范版本：    " , props.getProperty("java.vm.specification.version"));
        map.put("zb-Java的虚拟机规范供应商：    " , props.getProperty("java.vm.specification.vendor"));
        map.put("zb-Java的虚拟机规范名称：    " , props.getProperty("java.vm.specification.name"));
        map.put("zb-Java的虚拟机实现版本：    " , props.getProperty("java.vm.version"));
        map.put("zb-Java的虚拟机实现供应商：    " , props.getProperty("java.vm.vendor"));
        map.put("zb-Java的虚拟机实现名称：    " , props.getProperty("java.vm.name"));
        map.put("zb-Java运行时环境规范版本：    " , props.getProperty("java.specification.version"));
        map.put("zb-Java运行时环境规范供应商：    " , props.getProperty("java.specification.vender"));
        map.put("zb-Java运行时环境规范名称：    " , props.getProperty("java.specification.name"));
        map.put("zb-Java的类格式版本号：    " , props.getProperty("java.class.version"));
        map.put("zb-Java的类路径：    " , props.getProperty("java.class.path"));
        map.put("zb-加载库时搜索的路径列表：    " , props.getProperty("java.library.path"));
        map.put("zb-默认的临时文件路径：    " , props.getProperty("java.io.tmpdir"));
        map.put("zb-一个或多个扩展目录的路径：    " , props.getProperty("java.ext.dirs"));
        map.put("zb-操作系统的名称：    " , props.getProperty("os.name"));
        map.put("zb-操作系统的构架：    " , props.getProperty("os.arch"));
        map.put("zb-操作系统的版本：    " , props.getProperty("os.version"));
        map.put("zb-文件分隔符：    " , props.getProperty("file.separator"));
        map.put("zb-路径分隔符：    " , props.getProperty("path.separator"));
        map.put("zb-行分隔符：    " , props.getProperty("line.separator"));
        map.put("zb-用户的账户名称：    " , props.getProperty("user.name"));
        map.put("zb-用户的主目录：    " , props.getProperty("user.home"));
        map.put("zb-用户的当前工作目录：    " , props.getProperty("user.dir"));

        map.put("hs",(System.currentTimeMillis()-startTime)+"毫秒");
        System.out.println("耗时："+(System.currentTimeMillis()-startTime)+"毫秒");

        return "index/welcome";
    }
    @RequestMapping(value="/info",method=RequestMethod.POST)
    public String indexs(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
            // 日志中输出所有请求头
            System.out.println(String.format("Header '%s' = %s", key, value));
        });

        return "index/welcome";
    }
    @RequestMapping("/getInfo")
    @ResponseBody
    public Map<String,Object> getInfo() {
        return map;
    }
}

