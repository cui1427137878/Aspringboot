package com.tedu.nettyWebServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpServer {

	public static void main(String[] args) {
		System.out.println("web server启动了");

		// //启动服务器
		ServerBootstrap serverBootstrap = new ServerBootstrap();

		//设置成非阻塞式
		serverBootstrap = serverBootstrap.channel
				(NioServerSocketChannel.class);
		// 事件处理器
		NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
		//设置事件处理器
		serverBootstrap.group(nioEventLoopGroup);

		//设置请求处理类
		serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {

			@Override
			protected void initChannel(SocketChannel socketChannel) throws Exception {

				//得到管道
				ChannelPipeline channelPipeline = socketChannel.pipeline();
				channelPipeline.addLast("http-decoder", new HttpServerCodec());
				HttpServerHandler httpServerHandler = new HttpServerHandler();
				channelPipeline.addLast(httpServerHandler);
			}
		});

		serverBootstrap.bind(9008);

	}

}
