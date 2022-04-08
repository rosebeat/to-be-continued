//package com.example.sourcecode;
//
//import java.nio.*;
//
///**
// * @author kai·yang
// * @Date 2022/1/6 15:10
// */
//public abstract class MyIOByteBuffer extends Buffer implements Comparable<MyIOByteBuffer>{
//
//    final byte[] hb;
//
//    final int offset;
//
//    boolean isReadOnly;
//
//    MyIOByteBuffer(int mark, int pos, int lim, int cap, byte[] hb, int offset){
//        super(mark, pos, lim, cap);
//        this.hb = hb;
//        this.offset = offset;
//
//    }
//
//    MyIOByteBuffer(int mark, int pos, int lim, int cap) {
//        this(mark, pos, lim, cap, null, 0);
//    }
//
//
//    /**
//     * 分配一个新的直接字节缓冲区
//     * @param capacity
//     * @return
//     */
//    public static ByteBuffer allocateDirect(int capacity){
//        return new DirectByteBuffer(capacity);
//    }
//
//
//    /**
//     * 分配一个字节缓冲区
//     * @param capacity
//     * @return
//     */
//    public static ByteBuffer allcate(int capacity){
//        if (capacity < 0){
//            throw new IllegalArgumentException();
//        }
//        return new HeapByteBuffer(capacity,capacity);
//    }
//
//
//    /**
//     * 将一个字节数组包装到缓冲区
//     * @param array
//     * @param offset
//     * @param length
//     * @return
//     */
//    public static ByteBuffer wrap(byte[] array, int offset, int length){
//        try{
//            return new HeapByteBuffer(array,offset,length);
//        }catch (IllegalArgumentException e){
//            throw new IndexOutOfBoundsException();
//        }
//
//    }
//
//
//    /**
//     * 将一个字节数组包装到缓冲区
//     * @param array
//     * @return
//     */
//    public static ByteBuffer wrap(byte[] array){
//        return wrap(array, 0, array.length);
//    }
//
//
//    /**
//     * 创建一个新的缓冲区，内容是这个缓冲区的内容
//     * @return
//     */
//    public abstract ByteBuffer slice();
//
//
//    /**
//     * 创建共享此缓冲区内容的新字节缓冲区
//     * @return
//     */
//    public abstract ByteBuffer duplicate();
//
//
//    /**
//     * 创建一个新的只读缓冲区，共享这个缓冲区内容
//     * @return
//     */
//    public abstract ByteBuffer asReadOnlyBuffer();
//
//
//    /**
//     * 读取此缓冲区当前位置的字节，然后递增该位置
//     * @return
//     */
//    public abstract byte get();
//
//
//    /**
//     * 在当前位置将给定字节写入此缓冲区，然后递增位置
//     * @param b
//     * @return
//     */
//    public abstract byte put(byte b);
//
//
//    /**
//     * 读取指定位置上的字节
//     * @param index
//     * @return
//     */
//    public abstract byte get(int index);
//
//
//    /**
//     * 在指定位置上将给定的字节写入缓冲区
//     * @param index
//     * @param b
//     * @return
//     */
//    public abstract byte put(int index, byte b);
//
//
//    /**
//     *
//     * @param dst
//     * @param offset
//     * @param length
//     * @return
//     */
//    public MyIOByteBuffer get(byte[] dst, int offset, int length){
//        checkBounds(offset, length, dst.length);
//        if (length > remaining()){
//            throw new BufferUnderflowException();
//        }
//        int end = offset + length;
//        for (int i = offset; i < end; i++){
//            dst[i] = get();
//        }
//        return this;
//    }
//
//
//    /**
//     *
//     * @param dst
//     * @return
//     */
//    public MyIOByteBuffer get(byte[] dst){
//        return get(dst, 0, dst.length);
//    }
//
//
//
//    //bulk put operations
//
//    /**
//     *
//     * @param src
//     * @return
//     */
//    public MyIOByteBuffer put(MyIOByteBuffer src){
//        if (src == this){
//            throw new IllegalArgumentException();
//        }
//        if(isReadOnly()){
//            throw new ReadOnlyBufferException();
//        }
//        int n = src.remaining();
//        if (n > remaining()){
//            throw new BufferOverflowException();
//        }
//        for (int i = 0; i < n; i++){
//            put(src.get());
//        }
//        return this;
//    }
//
//
//    /**
//     *
//     * @param src
//     * @param offset
//     * @param length
//     * @return
//     */
//    public MyIOByteBuffer put(byte[] src, int offset, int length){
//        checkBounds(offset,length, src.length);
//        if (length > remaining()) {
//            throw new BufferOverflowException();
//        }
//        int end = offset + length;
//        for(int i = offset; i < end; i++){
//            this.put(src[i]);
//        }
//        return this;
//    }
//
//
//    public final MyIOByteBuffer put(byte[] src){
//        return put(src, 0, src.length);
//    }
//
//
//
//    // other stuff
//
//    /**
//     * 说明此缓冲区是否由可访问的数组支持
//     * @return
//     */
//    public final boolean hasArray(){
//        return (hb != null) && !isReadOnly;
//    }
//
//
//    /**
//     * 返回支持此操作的字节数组缓冲区
//     *
//     * 对此缓冲区内容的修改将导致返回数组内容修改
//     * @return
//     */
//    public final byte[] array(){
//        if (hb == null){
//            throw new UnsupportedOperationException();
//        }
//
//        if (isReadOnly){
//            throw new ReadOnlyBufferException();
//        }
//        return hb;
//    }
//
//
//    /**
//     * 返回缓冲区第一个元素在此缓冲区的备份数组中的偏移量
//     * @return
//     */
//    public final int arrayOffset(){
//        if (hb == null) {
//            throw new UnsupportedOperationException();
//        }
//        if (isReadOnly){
//            throw new ReadOnlyBufferException();
//        }
//        return offset;
//    }
//
//
//    /**
//     * 压缩缓冲区
//     *
//     *
//     * @return
//     */
//    public abstract ByteBuffer compact();
//
//
//    /**
//     * 返回总结此缓冲区状态的字符串
//     * @return
//     */
//    public String toString(){
//        StringBuffer sb = new StringBuffer();
//        sb.append(getClass().getName());
//        sb.append("[pos=");
//        sb.append(position());
//        sb.append(" lim=");
//        sb.append(limit());
//        sb.append(" cap=");
//        sb.append(capacity());
//        sb.append("]");
//        return sb.toString();
//    }
//
//
//    /**
//     * 返回此缓冲区当前的 hashcode
//     * @return
//     */
//    public int hashCode(){
//        int h = 1;
//        int p = position();
//        for (int i = limit() - 1; i >= p; i--){
//            h = 31 * h + (int)get(i);
//        }
//        return h;
//    }
//
//
//    /**
//     *
//     *
//     * 两个字节缓冲区 当且仅当
//     *   1、他们具有相同的元素类型
//     *   2、他们具有相同数量的剩余元素
//     *   3、剩余元素的两个序列独立于他们的起始位置，在点方向上相等
//     *
//     * 字节缓冲区不等于任何其他类型的对象
//     * @param ob
//     * @return
//     */
//    public boolean equals(Object ob){
//        if (this == ob) {
//            return true;
//        }
//        if (!(ob instanceof ByteBuffer)){
//            return false;
//        }
//        ByteBuffer that = (ByteBuffer)ob;
//        if (this.remaining() != that.remaining()){
//            return false;
//        }
//        int p = this.position();
//        for (int i = this.limit() - 1, j = that.limit() - 1; i >=p; i--, j--){
//            if(!equals(this.get(i), that.get(j))){
//                return false;
//            }
//        }
//        return true;
//    }
//
//
//    public static boolean equals(byte x, byte y){
//        return x == y;
//    }
//
//
//
//
//
//
//
//    public int compareTo(MyIOByteBuffer that) {
//        int n = this.position() + Math.min(this.remaining(), that.remaining());
//        for (int i = this.position(), j = that.position(); i < n; i++, j++){
//            int cmp = compare(this.get(i), that.get(j));
//            if (cmp != 0){
//                return cmp;
//            }
//        }
//        return this.remaining() = that.remaining();
//    }
//
//
//    private static int compare(byte x, byte y){
//        return Byte.compare(x, y);
//    }
//
//
//    boolean bigEnding = true; // package-private
//
//    boolean nativeByteOrder = (Bits.byteOrder() == ByteOrder.BIG_ENDIAN);
//
//
//    /**
//     * 检索此缓冲区的字节顺序
//     *
//     * 字节顺序用于读取或写入多字节值，以及创建作为该字节缓冲区视图的缓冲区。
//     * @return
//     */
//    public final ByteOrder order(){
//        return bigEnding ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
//    }
//
//
//    public final MyIOByteBuffer order(ByteOrder bo){
//        bigEnding = (bo == ByteOrder.BIG_ENDIAN);
//        nativeByteOrder = (bigEnding == (Bits.byteOrder() == ByteOrder.BIG_ENDIAN));;
//        return this;
//    }
//
//    //未选中的访问器，供ByteBufferAs-X-Buffer类使用
//    abstract byte _get(int i);
//    abstract byte _put(int i, byte b);
//
//
//
//
//    /**
//     * 读取该缓冲区当前位置的下两个字节，根据当前字节顺序将它们组合成一个char值，然后将该位置增加两个
//     * @return
//     */
//    public abstract char getChar();
//
//
//    /**
//     * 将包含给定字符值的两个字节按当前字节顺序写入当前位置的缓冲区，然后将该位置增加两个字节
//     * @param value
//     * @return
//     */
//    public abstract ByteBuffer putChar(char value);
//
//
//    /**
//     * 在给定位置上读取两个字节，并根据当前字节顺序将他们组合成一个 char
//     * @param index
//     * @return
//     */
//    public abstract char getChar(int index);
//
//
//    /**
//     * 将包含给定字符值的两个字节按照当前顺序写入到给定索引出的该缓冲区
//     * @param index
//     * @param value
//     * @return
//     */
//    public abstract ByteBuffer putChar(int index, byte value);
//
//
//    /**
//     *  在该字节缓冲区创建一个视图作为一个字符缓冲区
//     * @return
//     */
//    public abstract CharBuffer asCharBuffer();
//
//
//    /**
//     * 读取该缓冲区当前位置的下两个字节，根据当前字节顺序将他们组合成一个short， 然后在该位置增加两个字节
//     * @return
//     */
//    public abstract short getShort();
//
//
//    /**
//     * 将包含给定 short value的两个字节，按照当前顺序，写入到该缓冲区的当前位置，然后在该位置增加两个字节
//     * @param value
//     * @return
//     */
//    public abstract ByteBuffer putShort(short value);
//
//
//    /**
//     *
//     * @param index
//     * @return
//     */
//    public abstract short getShort(int index);
//
//
//    /**
//     *
//     * @param index
//     * @param value
//     * @return
//     */
//    public abstract ByteBuffer putShort(int index, byte value);
//
//
//    /**
//     * 在该字节缓冲区上创建一个视图作为一个短整型字节缓冲区
//     *
//     * 新缓冲区的内容将从缓冲区的当前位置开始，此缓冲区内容的更改将在新缓冲区中可见，反之亦然； 两个缓冲区的位置，极限和标记值将是独立的。
//     * @return
//     */
//    public abstract ShortBuffer asShortBuffer();
//
//
//    /**
//     * 读取该缓冲区当前位置的下四个字节，根据当前字节顺序将他们组合成一个int value， 然后在该位置上增加4个字节
//     * @return
//     */
//    public abstract int getInt();
//
//
//    /**
//     * 按照当前字节顺序将包含给定 int value 的四个字节写入到该缓冲区的当前位置，然后在该位置上增加4个字节
//     * @param value
//     * @return
//     */
//    public abstract ByteBuffer putInt(int value);
//
//
//    /**
//     * 在给定索引初读取4个字节，并根据当前字节顺序把他们组装为一个 int value
//     * @param index
//     * @return
//     */
//    public abstract int getInt(int index);
//
//
//    /**
//     * 在该缓冲区指定索引处将包含给定 int value 的四个字节写入到该缓冲区的当前位置
//     * @param index
//     * @param value
//     * @return
//     */
//    public abstract ByteBuffer putInt(int index, int value);
//
//
//    /**
//     *
//     * @return
//     */
//    public abstract IntBuffer asIntBuffer();
//
//
//
//
//
//
//
//
//
//    @Override
//    public boolean isReadOnly() {
//        return false;
//    }
//
//    @Override
//    public boolean hasArray() {
//        return false;
//    }
//
//    @Override
//    public Object array() {
//        return null;
//    }
//
//    @Override
//    public int arrayOffset() {
//        return 0;
//    }
//
//    @Override
//    public boolean isDirect() {
//        return false;
//    }
//}
