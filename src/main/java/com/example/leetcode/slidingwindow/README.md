## 滑动窗口

```java
//滑动窗口模板伪代码

//控制窗口右边界
for( int right = 0; right < s.length; right++){
    
    //控制窗口左边界
    //区间[left, right] 不符合题意
    while( left < right && check()){
        //扩展左边界
    }
    
    //区间[left, right]符合题意扩展右边界
    ……
}


```
