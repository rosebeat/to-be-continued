//package com.example.sourcecode;
//
//import oracle.jrockit.jfr.events.Bits;
//
//import java.nio.*;
//
///**
// * @author kai·yang
// * @Date 2022/1/18 10:02
// */
//public class MyIOHeapByteBuffer extends ByteBuffer {
//
//
//    MyIOMappedByteBuffer(int cap, int lim){
//        super(-1, 0, lim, cap, new byte[cap], 0);
//    }
//
//
//    MyIOMappedByteBuffer(byte[] buf, int off, int len){
//        super(-1, off, off + len, buf.length, buf, 0);
//    }
//
//
//    protected MyIOMappedByteBuffer(byte[] buf, int mark, int pos, int lim, int cap, int off){
//        super(mark, pos, lim, cap, buf, off);
//    }
//
//
//
//
//    public ByteBuffer duplicate(){
//
//        return new MyIOHeapByteBuffer(hb,this.markValue(),this.position(), this.limit(), this.capacity(), offset);
//    }
//
//
//    public ByteBuffer asReadOnlyBuffer(){
//
//        return new MyIOHeapByteBuffer(hb, this.markValue(), this.position(), this.limit(), this.capacity(), offset);
//    }
//
//
//     protected int ix(int i){
//        return i + offset;
//     }
//
//
//     public byte get(){
//        return hb[ix(nextGetIndex())];
//     }
//
//
//     public byte get(int i) {
//        return hb[ix(checkIndex(i))];
//     }
//
//
//
//     public ByteBuffer get(byte[] dst, int offset, int length){
//        checkBounds(offset, length, dst.length);
//        if (length > remaining()) {
//            throw new BufferUnderflowException();
//        }
//        System.arraycopy(hb, ix(position()), dst, offset, length);
//        position(position() + length);
//        return this;
//     }
//
//
//     public boolean isDirect(){
//        return false;
//     }
//
//
//     public boolean isReadOnly(){
//        return false;
//     }
//
//
//     public ByteBuffer put(byte x){
//        hb[ix(nextPutIndex(x))];
//        return this;
//     }
//
//
//     public ByteBuffer put(int i, byte x){
//        hb[ix(checkIndex(i))] = x;
//        return this;
//     }
//
//
//     public ByteBuffer put(byte[] src, int offset, int length){
//        checkBounds(offset, length, src.length);
//        if (length > remaining()){
//            throw new BufferOverflowException();
//        }
//        System.arraycopy(src, offset, hb, ix(position()), length);
//        position(position() + length);
//        return this;
//     }
//
//
//
//     public ByteBuffer put(ByteBuffer src){
//        if (src instanceof MyIOHeapByteBuffer){
//            if (src == this){
//                throw new IllegalArgumentException();
//            }
//            MyIOHeapByteBuffer sb = (MyIOHeapByteBuffer) src;
//            int n = sb.remaining();
//            if (n > remaining()){
//                throw new BufferOverflowException();
//            }
//            System.arraycopy(sb.hb, sb.ix(sb.position()), hb, ix(position()), n);
//            sb.position(sb.position() + n);
//            position(position() + n);
//        }else if(src.isDirect()){
//            int n = src.remaining();
//            if (n > remaining()){
//                throw new BufferOverflowException();
//            }
//            src.get(hb, ix(position()), n);
//            position(position() + n);
//        }else{
//            super.put(src);
//        }
//
//        return this;
//     }
//
//
//
//     public ByteBuffer compact(){
//        System.arraycopy(hb, ix(position()), hb, ix(0), remaining());
//        position(remaining());
//        limit(capacity());
//        discardMark();
//        return this;
//     }
//
//
//     byte _get(int i){
//        return hb[i];
//     }
//
//
//     void _put(int i, byte b){
//        hb[i] = b;
//     }
//
//
//    // char
//     public char getChar(){
//        return Bits.getChar(this, ix(nextGetIndex(2)), bigEndian);
//     }
//
//
//     public char getChar(int i){
//        return Bits.getChar(this, ix(checkIndex(i, 2)), bigEndian);
//     }
//
//
//     public ByteBuffer putChar(char x){
//        Bits.putChar(this, ix(nextPutIndex(2)), x, bigEndian);
//        return this;
//     }
//
//
//     public ByteBuffer putChar(int i, char x){
//        Bits.putChar(this, ix(checkIndex(i, 2)), x, bigEndian);
//        return this;
//     }
//
//
//     public CharBuffer asCharBuffer(){
//        int size = this.remaining() >> 1;
//
//        int off = offset + position();
//
//        return (bigEndian ? (charBuffer) (new ByteBufferAsCharBufferB(this, -1, 0,size,size,off))
//         : (CharBuffer) (new ByteBufferAsCharBufferL(this, -1, 0, size, size, off)));
//     }
//
//
//
//     //short
//
//    public short getShort(){
//        return Bits.getShort(this, ix(nextGetIndex(2)), bigEndian);
//    }
//
//    public short getShort(int i){
//        return Bits.getShort(this, ix(check(i, 2)), bigEndian);
//    }
//
//
//
//    public ByteBuffer putShort( short x){
//        Bigs.putShort(this, ix(nextPutIndex(2)), x, bigEndian);
//        return this;
//    }
//
//    public ByteBuffer putShort(int i, short x){
//        Bits.putShort(this, ix(checkIndex(i, 2)), x, bigEndian);
//        return this;
//    }
//
//    public ShortBuffer asShortBuffer(){
//        int size = this.remaining() >> 1;
//        int off = offset + position();
//        return (bigEndian ? (ShortBuffer)( new ByteBufferAsShortBufferB(this, -1, 0, size, size, off)):
//                (ShortBuffer) (new ByteBufferAsShortBufferL(this, -1, 0, size, size, off))
//                );
//    }
//
//
//    //int
//
//    public int getInt(){
//        return Bits.getInt(this, ix(nextGetIndex(4)), bigEndian);
//    }
//
//    public int getInt(int i){
//        return Bits.getInt(this, ix(checkIndex(i, 4)), bigEndian);
//    }
//
//    public ByteBuffer putInt(int x){
//        Bits.putInt(this, ix(nextPutIndex(4)), x, bigEndian);
//        return this;
//    }
//
//    public ByteBuffer putInt(int i, int x){
//        Bits.putInt(this, ix(checkIndex(i, 4)), x, bigEndian);
//        return this;
//    }
//
//    public IntBuffer asIntBuffer(){
//        int size = this.remaining() >> 2;
//        int off = offset + position();
//        return (bigEndian ? (IntBuffer)(new ByteBufferAsIntBufferB(this, -1, 0, size, size, off))
//                : (IntBuffer)(new ByteBufferAsIntBuuferL(this, -1, 0, size, size, off))
//                );
//
//    }
//
//
//    //long
//
//    public long getLong(){
//        return Bits.getLong(this, ix(nextGetIndex(8)), bigEndian);
//    }
//
//    public long getLong(long x){
//        return Bits.getLong(this, ix(checkIndex(x, 8)), bigEndian);
//    }
//
//    public ByteBuffer(long x){
//        Bits.putLong(this, ix(nextPutIndex(8)), x, bigEndian);
//        return this;
//    }
//
//
//
//
//}
