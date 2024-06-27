package com.example.inetty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.ThreadFactory;

/**
 * @author: kai·yang
 * @Date: 2024/6/18 11:49
 * @Description:
 */
public class NettyServerTouring {


    ThreadFactory boosTF = new DefaultThreadFactory("netty_httpServer_boss");

    ThreadFactory workTF = new DefaultThreadFactory("netty_httpServer_work");

    private NioEventLoopGroup boss;

    private NioEventLoopGroup works;


    public void Server() {
        boss = new NioEventLoopGroup(1, boosTF);
        works = new NioEventLoopGroup(50, workTF);
        ServerBootstrap b = new ServerBootstrap();
        b.group(boss, works)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {

                    }
                });
        // TODO
        // childOption 主要设置 每个接受的子通道（客户端连接到服务端后创建的通道）的配置选项。 这些选项通常是针对网络连接层面的设置，用于定制化
        // 每个连接的行为或性能，例如，你可以使用它来设置TCP参数、调整缓冲区大小、启用或禁用特定的Socket选项等。
        //关闭心跳监测
        b.childOption(ChannelOption.SO_KEEPALIVE, false);
        //如调整TCP_NODELAY（禁用Nagle算法，减少小包延迟）
        b.childOption(ChannelOption.TCP_NODELAY, true);
        //绑定端口号

        /*
          sync():
                功能：阻塞线程，知道bind操作完成，它会一直等下去，直到服务端的端口绑定成功或者出现异常
                中断处理：等待期间线程被中断，sync会抛出 InterruptedException异常，并且中断状态会被清除，调用者需要处理这个异常，并决定如何响应中断事件
          syncUninterruptibly()
                功能：同样是阻塞当前线程，直到bind操作完成
                中断处理：等待期间线程被中中断 不会抛出InterruptedException异常， 会继续等待操作完成。这对于那些不希望因为中断而停止或重新尝试操作的场景非常有用。
         */

        ChannelFuture channelFuture = b.bind(1688).syncUninterruptibly();
    }

}
