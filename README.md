## 软件可靠性G-O模型

### 一.模型原理
#### 模型基本假设：
###### （1）假设软件是在与预期操作环境相似的条件下运行；
###### （2）在任何时间序列t0<t1<••••<tn构成的时间区间（t0,t1），（t1,t2），•••，（tn-1tn）中检测到的失效数是相互独立的；
###### （3）每个失效的严重性和被检测到的可能性大致相同；
###### （4）在t时刻检测出的累计失效数N（t）是一个独立增量过程，N（t）服从期望为m（t）的Poisson分布，在（t，t+△t）时间区间中发现的失效数的期望正比于t时刻剩余失效的期望值；
###### （5）累积失效数的期望函数m（t）是一个有界的单调增函数，并满足：
* m（0）=0；
* lim m（t）=a；
* t->无穷.
* 式中，a是最终可能被检测出的失效总数的期望值。

#### 模型基本公式：  
![https://github.com/Mai-Pu/G-O/raw/master/pic/1.png]  
* 其中b是剩余失效发现率
* （t，t+x）区间的可靠性 ![https://github.com/Mai-Pu/G-O/raw/master/pic/2.png]  
* 到达开发要求的可靠度的时间(交付时间) ![https://github.com/Mai-Pu/G-O/raw/master/pic/3.png]
* 如果假设在时间序列t0<t1<•••tn上所查出的对应累计软件失效数为：y0<=y1<=•••<=yn,其中t0=0,y0=0，则可得由似然估计求得:
![https://github.com/Mai-Pu/G-O/raw/master/pic/4.png]
 
### 二.算法
![https://github.com/Mai-Pu/G-O/raw/master/pic/5.png]  

### 三.算法流程
![https://github.com/Mai-Pu/G-O/raw/master/pic/6.png]

### 四.验证数据
* 数据来自《软件可靠性模型及在通信软件中的应用研究_武会超》表3.2 某软件失效数据
![https://github.com/Mai-Pu/G-O/raw/master/pic/7.png]
* 其中i为测试时间单元，Xi表示测试时间单元内检测到的软件失效数，Ni表示时刻时刻ti时累计测试检测到的软件失效数；本次利用G-O模型，将第11到20个测试时间单元内的失效次数进行预测，本次将11~20存入程序的数组t[11]，其中t[0]=0,将第11到20个测试时间单元内的累积失效次数存入数组y[11],其中y[0]=0，便可通过程序得到想要的结果。

### 五.结果分析
* 输入：
![https://github.com/Mai-Pu/G-O/raw/master/pic/8.png]
* 首先输入需要预测的测试时间单元time=30，和验收时在[time,time+x]所需的可靠度R=0.5,还有区间大小x=5；

* 结果：
![https://github.com/Mai-Pu/G-O/raw/master/pic/9.png]
* 然后可以根据G-O模型和保存在程序里面的数组中的数据测试时间单元t和累积失效数y，得到所需的结果（如上图所示）。