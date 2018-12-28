# Android计步器
 
## 原理
    Android 4.4开始支持计步传感器Sensor.TYPE_STEP_COUNTER，会记录从设备启动开始到目前为止的步数，以此为核心来实现计步功能。开启一个Service，在其中实现传感器的监听，并将计步数传到Activity与通知栏与用户交互，并在Service中每隔30s保存一次数据以保证数据的精确。

    
    Android设备中存在计步传感器，可以通过状态的变化来实现计步功能。
    结合sharedPreference实现数据的存储。
    service中每30s存储一次数据，前台service降低被杀死的概率。
    
  ## 误差产生的原因
      
    理想状态下应该另APP一直在后台运行，并监听开关机的广播以及每日时间的变化来实现计步数据的改变，但由于各大手机厂商为了优化系统性能与提高电池的续航    里程，BOOT_COMPLETED、Service后台包活基本上是不起作用的，因此完全精准的计步器个人是不可能实现的。

    计步器传感器只对外提供了一个接口，并且必须在计步事件触发即人走一步后才可以得到数据，因此需要做到数据持久化。由于30s存储一次数据的机制以及Service不能做到保活会导致有一定的误差。

    因此添加开始计步与打卡按钮，采用手动开始计步的方式。开始计步即从点击事件触发后开始今日的计步，打卡后保存从上一次开始计步为止的步数，并可以查看运动记录。将计步服务设置为前台Service减少计步进程被杀死的几率。

  ## 关键
   ### Sensor 
    Android 4.4以上的设备开始支持计步传感器，当注册的传感器发生新事件时会触发onSensorChanged(SensorEvent event) 方法。
  
   ### Service 
    Service（服务）是Android中实现后台运行的解决方案，适合执行不需要与用户交互而且还要求长期运行的任务。服务一般实在后台运行的，由于优先级较低当系统  内存不足时会被回收，使用前台服务可以使服务更长时间保持运行状态。
  
   ### SharedPreferenced 
  Android系统中轻量级存储数据的一种方式，它的本质是基于XML文件存储Key-Value键值对数据。




## 完善
    修改主页面的自定义控件，实现小圆圈一直环绕的效果
    增添其他功能
    
<p align="center">
    <img src="https://github.com/1772084297/Odometer/blob/master/image1.png" alt="Sample"  width="250" height="500">
    <p align="center">
        <em>主页图片</em>
    </p>
</p>

<p align="center">
    <img src="https://github.com/1772084297/Odometer/blob/master/image2.png" alt="Sample"  width="250" height="400">
    <p align="center">
        <em>列表页图片</em>
    </p>
</p>

## 提交记录
-2018/12/15
    第一次提交，能基本实现正常情况下的功能，对于传感器数据的处理存在问题，继续完善
    
