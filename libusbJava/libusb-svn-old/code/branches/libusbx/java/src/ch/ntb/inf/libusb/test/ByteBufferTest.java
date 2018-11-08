package ch.ntb.inf.libusb.test;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ByteBufferTest {

	private static List<ByteBuffer> nativeDevList;
	private static List<ByteBuffer> testList0;
	private static List<ByteBuffer> testList1;
	
	public static void main(String[] args) {
		
		nativeDevList = new ArrayList<ByteBuffer>();
		testList0 = new ArrayList<ByteBuffer>();
		testList1 = new ArrayList<ByteBuffer>();

		//fill Lists
		ByteBuffer adrDev0 = ByteBuffer.allocateDirect(8);
		adrDev0.putInt(0xaa);
		ByteBuffer adrDev1 = ByteBuffer.allocateDirect(8);
		adrDev1.putInt(0xbb);
		ByteBuffer adrDev2 = ByteBuffer.allocateDirect(8);
		adrDev2.putInt(0xcc);
		nativeDevList.add(adrDev0);
		nativeDevList.add(adrDev1);
		nativeDevList.add(adrDev2);
		
		testList0.add(adrDev1);
		testList0.add(adrDev2);
		testList0.add(adrDev0);
		
		testList1.add(adrDev0);
		testList1.add(adrDev1);
		testList1.add(adrDev2);
		
		//test it
		System.out.println("----compareTo----");
		if(nativeDevList.get(0).compareTo(testList1.get(0)) == 0){
			//are equal
			System.out.println("nativeDevList[0] == testList1[0]");
		}
		else{
			System.out.println("nativeDevList[0] != testList1[0]");
		}
		if(nativeDevList.get(1).compareTo(testList1.get(1)) == 0){
			//are equal
			System.out.println("nativeDevList[1] == testList1[1]");
		}
		else{
			System.out.println("nativeDevList[1] != testList1[1]");
		}
		if(nativeDevList.get(2).compareTo(testList1.get(2)) == 0){
			//are equal
			System.out.println("nativeDevList[2] == testList1[2]");
		}
		else{
			System.out.println("nativeDevList[2] != testList1[2]");
		}
		
		if(nativeDevList.get(0).compareTo(testList0.get(0)) == 0){
			System.out.println("nativeDevList[0] == testList0[0]");
		}
		else{
			System.out.println("nativeDevList[0] != testList0[0]");
		}
		if(nativeDevList.get(1).compareTo(testList0.get(1)) == 0){
			System.out.println("nativeDevList[1] == testList0[1]");
		}
		else{
			System.out.println("nativeDevList[1] != testList0[1]");
		}
		if(nativeDevList.get(2).compareTo(testList0.get(2)) == 0){
			System.out.println("nativeDevList[2] == testList0[2]");
		}
		else{
			System.out.println("nativeDevList[2] != testList0[2]");
		}
		
		System.out.println("----==----");
		if(nativeDevList.get(0) == testList0.get(0)){
			System.out.println("nativeDevList[0] == testList0[0]");
		}
		else{
			System.out.println("nativeDevList[0] != testList0[0]");
		}
		if(nativeDevList.get(1) == testList0.get(1)){
			System.out.println("nativeDevList[1] == testList0[1]");
		}
		else{
			System.out.println("nativeDevList[1] != testList0[1]");
		}
		if(nativeDevList.get(2) == testList0.get(2)){
			System.out.println("nativeDevList[2] == testList0[2]");
		}
		else{
			System.out.println("nativeDevList[2] != testList0[2]");
		}
		if(nativeDevList.get(0) == testList1.get(0)){
			//are equal
			System.out.println("nativeDevList[0] == testList1[0]");
		}
		else{
			System.out.println("nativeDevList[0] != testList1[0]");
		}
		if(nativeDevList.get(1) == testList1.get(1)){
			//are equal
			System.out.println("nativeDevList[1] == testList1[1]");
		}
		else{
			System.out.println("nativeDevList[1] != testList1[1]");
		}
		if(nativeDevList.get(2) == testList1.get(2)){
			//are equal
			System.out.println("nativeDevList[2] == testList1[2]");
		}
		else{
			System.out.println("nativeDevList[2] != testList1[2]");
		}
	}

}
