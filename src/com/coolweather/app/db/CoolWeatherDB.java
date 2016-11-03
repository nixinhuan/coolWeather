package com.coolweather.app.db;

import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.List;

import com.coolweather.app.model.City;
import com.coolweather.app.model.Province;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CoolWeatherDB {
	
			public static final String DB_NAME="cool_weather";
			
			public static final int version=1;
			private static CoolWeatherDB coolWeatherDB;
			private SQLiteDatabase database;
			
			private CoolWeatherDB(Context context){
				CoolWeatherOpenHelper dbHelper=new CoolWeatherOpenHelper(context, DB_NAME, null, version);
				database = dbHelper.getWritableDatabase();
			}
			
			public synchronized static CoolWeatherDB getInstance(Context context) {
				if(coolWeatherDB==null){
					coolWeatherDB=new CoolWeatherDB(context);
				}
				return coolWeatherDB;
				
			}
			
			public void saveProvince(Province province){
				if(province!=null){
					ContentValues values=new ContentValues();
					values.put("province_name", province.getProvinceName());
					values.put("province_code", province.getProvinceCode());
				   database.insert("Province", null, values);
				}
			}
			
			public  List<Province> loadProvince(){
				
				List<Province> list=new ArrayList<Province>();
				Cursor cursor = database.query("Province", null, null, null, null, null, null);
				
				if(cursor.moveToFirst()){
					do{
						Province province=new Province();
						province.setId(cursor.getInt(cursor.getColumnIndex("id")));
						province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
						province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
						list.add(province);
					}while(cursor.moveToNext());
				}
				
				return list;
				
			}
			

}
