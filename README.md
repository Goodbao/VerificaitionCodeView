# VerificationCodeView
[Android 自定义View_方框验证码](https://www.jianshu.com/p/eb5b161c8a0e)

![VerificationCodeView](https://upload-images.jianshu.io/upload_images/1627327-94467145f870ac3b.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/400/format/webp)

方框验证码View

刚开始做这个自定义view，我是想着用多个EditText来实现功能，做到后面发现在获取焦点这个问题上，多个EditText处理不了，于是上网看了别的思路，就是用多个TextView显示，但是输入的EditText只有一个，我觉得这个思路可行，自己再次动手改代码。

具体：这个View就是继承与RelativeLayout，然后里面有一个LinearLayout，水平排列放下6个TextView,最后在LinearLayout上盖上一个字体大小为0的EditText。
EditText做监听，将内容赋值给每一个TextView。
