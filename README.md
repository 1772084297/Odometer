# Android计步器
 
## 原理
    Android设备中存在计步传感器，可以通过状态的变化来实现计步功能。
    结合sharedPreference实现数据的存储。
    service中每30s存储一次数据，前台service降低被杀死的概率。
    
## 完善
    修改主页面的自定义控件，实现小圆圈一直环绕的效果
    增添其他功能
    
<p align="center">
    <img src="https://github.com/1772084297/Odometer/blob/master/image1.png==/dissolve/70" alt="Sample"  width="250" height="140">
    <p align="center">
        <em>图片示例2</em>
    </p>
</p>

![image](https://github.com/1772084297/Odometer/blob/master/image1.png)    
## 提交记录
-2018/12/15
    第一次提交，能基本实现正常情况下的功能，对于传感器数据的处理存在问题，继续完善
    
