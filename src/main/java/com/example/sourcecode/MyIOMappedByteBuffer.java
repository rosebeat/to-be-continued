//package com.example.sourcecode;
//
//
//import oracle.jrockit.jfr.events.Bits;
//import sun.misc.Unsafe;
//
//import java.io.FileDescriptor;
//import java.nio.ByteBuffer;
//import java.nio.MappedByteBuffer;
//
///**
// * @author kai·yang
// * @Date 2022/1/13 16:48
// */
//public abstract class MyIOMappedByteBuffer extends ByteBuffer {
//
//    //对于映射缓冲区，如果有效，则可以用于映射操作的文件描述符；如果缓冲区未映射，则为null
//
//    private final FileDescriptor fd;
//
//
//    MyIOMappedByteBuffer(int mark, int pos, int lim, int cap, FileDescriptor fd){
//        super(mark, pos, lim, cap);
//        this.fd = fd;
//    }
//
//    MyIOMappedByteBuffer(int mark, int pos, int lim, int cap){
//        super(mark, pos, lim, cap);
//        this.fd = null;
//    }
//
//    private void checkappen(){
//        if (fd == null) {
//            // can only happen if a luser explicitly casts a direct byte buffer
//            throw new UnsupportedOperationException();
//        }
//    }
//
//
//    //returns the distance (in bytes) of the buffer from the page aligned address
//    //of the mapping. computed each time to avoid storing in every direct buffer
//    private long mappingOffset(){
//        int ps = Bits.pageSize();
//        long offset = address % ps;
//        return (offset >= 0) ? offset : (ps + offset);
//    }
//
//
//    private long mappingAddress(long mappingOffset){
//        return address - mappingOffset;
//    }
//
//
//    private long mappingLength(long mappingOffset){
//        return (long)capacity() + mappingOffset;
//    }
//
//
//
//    public final boolean isLoaded(){
//        checkappen();
//
//        if((address == 0) || (capacity() == 0)){
//            return true;
//        }
//
//        long offset = mappingOffset();
//        long length = mappingLength(offset);
//        return isLoaded0(mappingAddress(offset), length, Bits.pageCount(length));
//    }
//
//
//    // not used, but a potential target for a store, see load() for details
//    private static byte unused;
//
//
//    /**
//     * 把缓冲区内容加载到物理内存中
//     * 此方法尽最大努力确保在返回时，缓冲区的内容驻留在物理内存中，调用此方法可能会导致出现一下页面错误和I/O操作
//     * @return
//     */
//    public final MyIOMappedByteBuffer load(){
//        checkappen();
//        if ((address == 0) || (capacity() == 0)){
//            return this;
//        }
//
//        long offset = mappingOffset();
//        long length = mappingLength(offset);
//        load0(mappingAddress(offset), length);
//
//
//        //从每页读取一个字节将其放入内存中，我们在进行时会计算和校验，防止编译器把他当作死循环代码
//        Unsafe unsafe = Unsafe.getUnsafe();
//        int ps = Bits.pageSize();
//        int count = Bits.pageCount(length);
//        long a = mappingAddress(offset);
//        byte x = 0;
//        for (int i = 0; i < count; i++){
//            x ^= unsafe.getByte(a);
//            a += ps;
//        }
//        if (unused != 0) {
//            unused = x;
//        }
//        return this;
//    }
//
//
//    /**
//     * 强制将对缓冲区内容的任何更改 写入到存储设备的映射文件中
//     * @return
//     */
//    public final MyIOMappedByteBuffer force(){
//        checkappen();
//        if ((address != 0) && (capacity() != 0)){
//            long offset = mappingOffset();
//            force0(fd,mappingAddress(offset), mappingLength(offset));
//        }
//        return this;
//    }
//
//
//
//
//    private native boolean isLoaded0(long address, long length, int pageCount);
//
//    private native void load0(long address, long length);
//
//    private native void force0(FileDescriptor fd, long address, long length);
//
//
//}
