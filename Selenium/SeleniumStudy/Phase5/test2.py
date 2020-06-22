import unittest
import os, sys
import time
import HTMLTestRunner

def createsuite():
    # 通过递归的方式，从指定的目录开始，找到所有与模式匹配的文件
    discovers = unittest.defaultTestLoader.discover("../Phase5", pattern="Baidu*.py", top_level_dir=None)
    print(discovers)
    return discovers


if __name__=="__main__":
    # sys.path 是 python 的搜索模块的路径集，返回的结果是一个 list
    # curpath = sys.path[0]
    # print(sys.path)
    # print(sys.path[0])
    # if not os.path.exists(curpath+'/resultreport'):
    #     os.makedirs(curpath+'/resultreport')

    if not os.path.exists('./resultreport'):    # 如果当前路径下没有该文件夹
        os.makedirs('./resultreport')           # 在当前路径下创建该文件夹

    # time.strftime(format[, t])
    # strftime 函数的作用是转化时间戳为指定的格式
    # time() 函数用于返回时间戳（1970年01月08时00分00秒到现在的秒数）

    now = time.strftime("%Y-%m-%d：%H-%M-%S", time.localtime(time.time()))    # 将当前时间转化为格式化的字符串
    print(time.localtime(time.time()))
    print(now)
    filename='./resultreport/'+now+'report.html'
    with open(filename, 'wb') as fp:    # 以写的方式打开文件
        runner = HTMLTestRunner.HTMLTestRunner(stream=fp, title=u"测试报告", description=u"用例执行情况",
                                             verbosity=1)
        suite = createsuite()
        runner.run(suite)
