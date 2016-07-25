/*
 * TitleValueColorEntity.java
 * Android-Charts
 *
 * Created by limc on 2011/05/29.
 *
 * Copyright 2011 limc.cn All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.engineermaster.demoapp;


import android.util.Log;

public class TitleValueColorEntity extends TitleValueEntity implements
		IHasColor {


	private int color;
	private  String title;

	public TitleValueColorEntity(String title, float value, int color) {
		super(title, value);
		this.color = color;

		Log.d("piechart",title);
		Log.d("piechart2", String.valueOf(color));
		Log.d("piechart3", String.valueOf(value));
	}

	public TitleValueColorEntity() {
		super();
	}


	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public void setString(String title) {
		this.title=title;
	}

	public String getString(){
		return title;
	}
}
