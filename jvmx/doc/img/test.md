# 栈帧-操作数栈


<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/244997/1589865088150-744bb718-f3fa-4ce3-acc8-87792aa44898.png#align=left&display=inline&height=436&margin=%5Bobject%20Object%5D&name=image.png&originHeight=292&originWidth=414&size=19933&status=done&style=none&width=618#align=left&display=inline&height=292&margin=%5Bobject%20Object%5D&originHeight=292&originWidth=414&status=done&style=none&width=414)<br />
<br />

<a name="9b636446"></a>
# 操作数栈（Operand Stack）

<br />1.栈 ：可以使用数组或者链表来实现<br />2.每一个独立的栈帧中除了包含局部变量表以外，还包含一个后进先出的操作数栈，也可以成为表达式栈<br />**3.操作数栈，在方法执行过程中，根据字节码指令，往栈中写入数据或提取数据，即入栈（push）或出栈（pop）**<br />**<br />某些字节码指令将值压入操作数栈，其余的字节码指令将操作数取出栈，使用他们后再把结果压入栈。（如字节码指令bipush操作）<br />比如：执行复制、交换、求和等操作<br />代码举例<br /> <br />![](https://cdn.nlark.com/yuque/0/2020/png/244997/1589896825570-04763369-0857-4cf1-a973-1d678f47416d.png#align=left&display=inline&height=313&margin=%5Bobject%20Object%5D&originHeight=656&originWidth=1784&size=0&status=done&style=none&width=851#align=left&display=inline&height=656&margin=%5Bobject%20Object%5D&originHeight=656&originWidth=1784&status=done&style=none&width=1784)<br /> <br />

<a name="8b63c166"></a>
## 操作数栈特点


- 操作数栈，**主要用于保存计算过程的中间结果，同时作为计算过程中变量临时的存储空间。**
- 操作数栈就是jvm执行引擎的一个工作区，当一个方法开始执行的时候，一个新的栈帧也会随之被创建出来，这个方法的操作数栈是空的
- 每一个操作数栈都会拥有一个明确的栈深度用于存储数值，其所需的最大深度在编译器就定义好了，保存在方法的code属性中，为max_stack的值。
- 栈中的任何一个元素都是可以任意的java数据类型
   - 32bit的类型占用一个栈单位深度
   - 64bit的类型占用两个栈深度单位
- 操作数栈**并非采用访问索引的方式来进行数据访问**的，而是只能通过标准的入栈push和出栈pop操作来完成一次数据访问
- **如果被调用的方法带有返回值的话，其返回值将会被压入当前栈帧的操作数栈中，**并更新PC寄存器中下一条需要执行的字节码指令。
- 操作数栈中的元素的数据类型必须与字节码指令的序列严格匹配，这由编译器在编译期间进行验证，同时在类加载过程中的类验证阶段的数据流分析阶段要再次验证。
- 另外，我们说Java虚拟机的**解释引擎是基于栈的执行引擎**,其中的栈指的就是操作数栈。


<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />

<a name="124ec189"></a>
## 操作数栈代码追踪

<br />结合上图结合下面的图来看一下一个方法（栈帧）的执行过程<br />①15入栈；②存储15，15进入局部变量表<br />注意：局部变量表的0号位被构造器占用，这里的15从局部变量表1号开始<br />![](https://cdn.nlark.com/yuque/0/2020/png/244997/1589896825578-9632a14a-d8a9-404a-b9bb-1721951fb91e.png#align=left&display=inline&height=422&margin=%5Bobject%20Object%5D&originHeight=908&originWidth=1808&size=0&status=done&style=none&width=841#align=left&display=inline&height=908&margin=%5Bobject%20Object%5D&originHeight=908&originWidth=1808&status=done&style=none&width=1808)<br /> <br /> <br />③压入8；④8出栈，存储8进入局部变量表；<br />![](https://cdn.nlark.com/yuque/0/2020/png/244997/1589896825587-0d71aa2e-17f9-4394-a278-00a343a03580.png#align=left&display=inline&height=441&margin=%5Bobject%20Object%5D&originHeight=912&originWidth=1786&size=0&status=done&style=none&width=864#align=left&display=inline&height=912&margin=%5Bobject%20Object%5D&originHeight=912&originWidth=1786&status=done&style=none&width=1786)<br /> <br /> <br />⑤从局部变量表中把索引为1和2的是数据取出来，放到操作数栈；⑥iadd相加操作<br />![](https://cdn.nlark.com/yuque/0/2020/png/244997/1589896825571-bff81ddc-0ab3-4042-85dd-842b25f0fed9.png#align=left&display=inline&height=463&margin=%5Bobject%20Object%5D&originHeight=922&originWidth=1780&size=0&status=done&style=none&width=894#align=left&display=inline&height=922&margin=%5Bobject%20Object%5D&originHeight=922&originWidth=1780&status=done&style=none&width=1780)<br /> <br /> <br />⑦iadd操作结果23出栈⑧将23存储在局部变量表索引为3的位置上istore_3<br />![](https://cdn.nlark.com/yuque/0/2020/png/244997/1589896825664-d578dec0-1d72-4b13-a1fd-0b76b4c9e43e.png#align=left&display=inline&height=454&margin=%5Bobject%20Object%5D&originHeight=920&originWidth=1796&size=0&status=done&style=none&width=886#align=left&display=inline&height=920&margin=%5Bobject%20Object%5D&originHeight=920&originWidth=1796&status=done&style=none&width=1796)<br />

<a name="75d896e3"></a>
## 栈顶缓存技术ToS（Top-of-Stack Cashing）


- 基于栈式架构的虚拟机所使用的零地址指令（即不考虑地址，单纯入栈出栈）更加紧凑，但完成一项操作的时候必然需要使用更多的入栈和出栈指令，这同时也就意味着将需要更多的指令分派（instruction dispatch）次数和内存读/写次数
- 由于操作数是存储在内存中的，因此频繁地执行内存读/写操作必然会影响执行速度。为了解决这个问题，HotSpot JVM的设计者们提出了栈顶缓存技术，**将栈顶元素全部缓存在物理CPU的寄存器中，以此降低对内存的读/写次数，提升执行引擎的执行效率**
