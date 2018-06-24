package com.wangwei.concurrency.example.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by wangwei on 2018/3/26.
 * 接收/处理/响应客户端websocket请求的核心处理类
 */
@Slf4j
public class MyWebSocketHandler extends SimpleChannelInboundHandler<Object> {

    private WebSocketServerHandshaker handshaker;

    private static final String WEB_SOCKET_URL = "ws://localhost:8888//websocket";

    /**
     * 客户端与服务端创建连接的时候调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        NettyConfig.channelGroup.add(ctx.channel());
        log.info("客户端与服务端连接开启。。。。。。");
    }

    /**
     * 客户端与服务端断开连接的时候调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        NettyConfig.channelGroup.remove(ctx.channel());
        log.info("客户端与服务端连接关闭");
    }

    /**
     * 服务端接受客户端发送过来的数据之后调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    /**
     * 工程出现异常时调用
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


    /**
     * 服务端处理客户端websocket请求的核心方法
     * @param channelHandlerContext
     * @param o
     * @throws Exception
     */
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

        //处理客户端向服务端发起http握手请求的业务
        if (o instanceof FullHttpRequest){

        }else if(o instanceof WebSocketFrame){//处理websocket连接业务

        }

    }


    /**
     * 处理客户端向服务端发起http握手请求的业务
     * @param ctx
     * @param request
     */
    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest request){

    }




}
