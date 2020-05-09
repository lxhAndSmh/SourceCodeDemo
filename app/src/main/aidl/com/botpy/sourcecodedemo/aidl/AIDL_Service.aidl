// AIDL_Service.aidl
package com.botpy.sourcecodedemo.aidl;

// Declare any non-default types here with import statements
/**
  AIDL 支持的数据类型
  1.基本数据类型
  2.String 和 CharSequence
  3.List 和 Map,但其对象的元素必须是 AIDL 支持的数据类型
  4.AIDL 自动生成的接口
  5.实现 Parcelable 接口进行序列化的类
 */
interface AIDL_Service {
    void AIDL_service();
}
