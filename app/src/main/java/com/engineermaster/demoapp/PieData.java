/**
 * Copyright 2014  XCL-Charts
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 	
 * @Project XCL-Charts 
 * @Description Android图表基类库
 * @author XiongChuanLiang<br/>(xcl_168@aliyun.com)
 * @license http://www.apache.org/licenses/  Apache v2 License
 * @version 1.0
 */
package com.engineermaster.demoapp;



/**
 * @ClassName PieData
 * @Description 数据类, 饼图,rose图,环形图等都用这个传数据
 * @author XiongChuanLiang<br/>(xcl_168@aliyun.com)
 *  
 */

public class PieData {
	private String mPieKey = "";
	private String mPieLabel = "";
	private double mPieValue = 0.0D;
	private int mPieColor = 0;
	private boolean mSelected = false;
	private float mItemLabelRotateAngle = 0.0F;
	private XEnum.SliceLabelStyle mLabelStyle;
	private boolean mCustLabelStyle;
	private int mCustLabelColor;

	public PieData() {
		this.mLabelStyle = XEnum.SliceLabelStyle.INSIDE;
		this.mCustLabelStyle = false;
		this.mCustLabelColor = 0;
	}

	public PieData(String label, double percent, int color) {
		this.mLabelStyle = XEnum.SliceLabelStyle.INSIDE;
		this.mCustLabelStyle = false;
		this.mCustLabelColor = 0;
		this.setLabel(label);
		this.setPercentage(percent);
		this.setSliceColor(color);
	}

	public PieData(String label, double percent, int color, boolean selected) {
		this.mLabelStyle = XEnum.SliceLabelStyle.INSIDE;
		this.mCustLabelStyle = false;
		this.mCustLabelColor = 0;
		this.setLabel(label);
		this.setPercentage(percent);
		this.setSliceColor(color);
		this.setSelected(selected);
	}

	public PieData(String key, String label, double percent, int color) {
		this.mLabelStyle = XEnum.SliceLabelStyle.INSIDE;
		this.mCustLabelStyle = false;
		this.mCustLabelColor = 0;
		this.setLabel(label);
		this.setPercentage(percent);
		this.setSliceColor(color);
		this.setKey(key);
	}

	public PieData(String key, String label, double percent, int color, boolean selected) {
		this.mLabelStyle = XEnum.SliceLabelStyle.INSIDE;
		this.mCustLabelStyle = false;
		this.mCustLabelColor = 0;
		this.setLabel(label);
		this.setPercentage(percent);
		this.setSliceColor(color);
		this.setKey(key);
		this.setSelected(selected);
	}

	public void setKey(String key) {
		this.mPieKey = key;
	}

	public String getKey() {
		return this.mPieKey;
	}

	public void setLabel(String label) {
		this.mPieLabel = label;
	}

	public void setPercentage(double value) {
		this.mPieValue = value;
	}

	public void setSliceColor(int color) {
		this.mPieColor = color;
	}

	public void setSelected(boolean selected) {
		this.mSelected = selected;
	}

	public String getLabel() {
		return this.mPieLabel;
	}

	public double getPercentage() {
		return this.mPieValue;
	}

	public boolean getSelected() {
		return this.mSelected;
	}

	public int getSliceColor() {
		return this.mPieColor;
	}

	public float getItemLabelRotateAngle() {
		return this.mItemLabelRotateAngle;
	}

	public void setItemLabelRotateAngle(float rotateAngle) {
		this.mItemLabelRotateAngle = rotateAngle;
	}

	public void setCustLabelStyle(XEnum.SliceLabelStyle style, int color) {
		this.mLabelStyle = style;
		this.mCustLabelStyle = true;
		this.mCustLabelColor = color;
	}

	public XEnum.SliceLabelStyle getLabelStyle() {
		return this.mLabelStyle;
	}

	public boolean getCustLabelStyleStatus() {
		return this.mCustLabelStyle;
	}

	public int getCustLabelColor() {
		return this.mCustLabelColor;
	}
}
