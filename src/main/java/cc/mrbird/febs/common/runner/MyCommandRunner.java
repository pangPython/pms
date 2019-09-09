package cc.mrbird.febs.common.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * @author tongch -Administrator
 * @version 1.0
 * @classname MyCommandRunner
 * @date 2019/09/09 22:30
 * @description 设置项目启动 使用系统默认浏览器 自动跳转
 **/
@Slf4j
@Component
public class MyCommandRunner implements CommandLineRunner {
    
    @Value("${server.port:8080}")
    private String port;
    
    @Override
    public void run(String... args) throws Exception {
        //获取本地ip
        InetAddress address = InetAddress.getLocalHost();
        String url = String.format("http://%s:%s", address.getHostAddress(), port);
        log.info("当前项目启动地址为 -> {}", url);
        //使用默认浏览器打开系统首页
        Runtime.getRuntime().exec("cmd  /c  start " + url);
    }
}
