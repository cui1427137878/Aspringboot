package com.tedu.nettyWebServer;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.file.Paths;
import java.util.Random;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpChunkedInput;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.stream.ChunkedFile;

public class HttpServerHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof HttpRequest) {

			HttpRequest request = (HttpRequest) msg;
			String method = request.method().toString();
			String uri = request.uri();
			System.out.println(method + "  " + uri);

			FullHttpResponse response = null;
			String html = null;

			// 响应行 http1.1 ok
			// 响应头 content-type:text/html;chatset=utf-8
			// 响应体 html
			//File file = new File("d:/" + uri);
			File file = new File("index.html");
			byte[] data = null;
			if (file.exists() == false) {

				html = "404文件不存在 <a href>baidu</a>";
				data = html.getBytes("utf-8");
				// 响应行
				response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND);
			} else {
				response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);

				FileInputStream fileInputStream = new FileInputStream(file);
				int size = fileInputStream.available();
				data = new byte[size];
				fileInputStream.read(data);

			}

			// 响应头
			HttpHeaders headers = response.headers();
			headers.add(HttpHeaderNames.CONTENT_TYPE, "text/html;charset=utf-8");
			headers.add(HttpHeaderNames.CONTENT_LENGTH, data.length);

			// 响应体
			ByteBuf content = response.content();
			content.writeBytes(data);
			// 发送数据
			ctx.writeAndFlush(response);
		
		}

	}

}
