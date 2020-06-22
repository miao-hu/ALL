import unittest
import os, sys, csv
import time
from Phase5 import Baidu1
from Phase5 import Baidu2

# 把每一个测试用例都添加到测试容器中
def createsuite():

    # 第一种： unittest.makeSuite(文件名.类名)   -----把这个类中的所有测试用例都添加到容器中
    # suite = unittest.TestSuite()                  # 生成一个测试容器实例对象
    # suite.addTest(unittest.makeSuite(Baidu1.Baidu1))
    # suite.addTest(unittest.makeSuite(Baidu2.Baidu1))
    # return suite


    # 第二种： 文件名.类名（"方法名"）    ------每次只添加一个测试用例,按照测试用例的添加顺序来执行
    # suite = unittest.TestSuite()           # 生成一个测试容器实例对象
    # suite.addTest(Baidu2.Baidu1("test_baidusearch"))
    # suite.addTest(Baidu1.Baidu1("test_hao"))
    # suite.addTest(Baidu1.Baidu1("test_baidusearch"))
    # return suite


    suite1 = unittest.TestLoader().loadTestsFromTestCase(Baidu1.Baidu1)
    suite2 = unittest.TestLoader().loadTestsFromTestCase(Baidu2.Baidu1)
    suite = unittest.TestSuite([suite1, suite2])
    return suite

if __name__=="__main__":
    suite = createsuite()    # 得到一个测试容器（里面有很多测试用例）
    runner = unittest.TextTestRunner(verbosity=2)
    runner.run(suite)        # 执行测试容器中的每一个测试用例
