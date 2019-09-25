package com.example.springBootDemo.designMode.proxy;

/*
 * 代理模式:
 * 客户端通过代理类访问，代理类实现具体的实现细节，客户只需要使用代理类即可实现操作。
 * 这种模式可以对旧功能进行代理，用一个代理类调用原有的方法，且对产生的结果进行控制。
 */
interface Source{
	void method() ; 
}

class OldClass implements Source{
	
    @Override
    public void method() {
    		
    }
}

public class Proxy implements Source {
	private Source source = new OldClass();

    void doSomething(){}
    @Override
    public void method() {
//        new Class1().Func1();
//        source.method();
//        new Class2().Func2();
//        doSomething();
    }
}
