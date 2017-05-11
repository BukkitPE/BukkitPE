package net.BukkitPE.raknet.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import net.BukkitPE.utils.ThreadedLogger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * BukkitPE Project
 */
public class UDPServerSocket extends ChannelInboundHandlerAdapter {

    protected final ThreadedLogger logger;
    protected Bootstrap bootstrap;
    protected EventLoopGroup group;
    protected Channel channel;

    protected ConcurrentLinkedQueue<DatagramPacket> packets = new ConcurrentLinkedQueue<>();

    public UDPServerSocket(ThreadedLogger logger) {
        this(logger, 19132, "0.0.0.0");
    }

    public UDPServerSocket(ThreadedLogger logger, int port) {
        this(logger, port, "0.0.0.0");
    }

    public UDPServerSocket(ThreadedLogger logger, int port, String interfaz) {
        this.logger = logger;
        try {
            bootstrap = new Bootstrap();
            group = new NioEventLoopGroup();
            bootstrap
                    .group(group)
                    .channel(NioDatagramChannel.class)
                    .handler(this);
            channel = bootstrap.bind(interfaz, port).sync().channel();
        } catch (InterruptedException e) {
            this.logger.critical("**** FAILED TO BIND TO " + interfaz + ":" + port + "!");
            this.logger.critical("-------------------------------------------------");
            this.logger.critical("There may be another server running on that port!");
            this.logger.critical("--------------------------------------------------");
            System.exit(1);
        }
    }

    public void close() {
        this.group.shutdownGracefully();
        try {
            this.channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public DatagramPacket readPacket() throws IOException {
        return this.packets.poll();
    }

    public int writePacket(byte[] data, String dest, int port) throws IOException {
        return this.writePacket(data, new InetSocketAddress(dest, port));
    }

    public int writePacket(byte[] data, InetSocketAddress dest) throws IOException {
        channel.writeAndFlush(new DatagramPacket(Unpooled.wrappedBuffer(data), dest));
        return data.length;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        this.packets.add((DatagramPacket) msg);
    }
}
