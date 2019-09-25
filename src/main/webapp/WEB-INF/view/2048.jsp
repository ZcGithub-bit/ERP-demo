<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
    <title>2048小游戏</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no"></meta>
    <script src="https://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css" href="css/2048.css"/>
    <script type="text/javascript" src="js/2048.js"></script>
</head>
<body>

<div class="container">
    <div class="main">
        <div class="gameName">2048小游戏</div>
        <div class="maxScore">最高分：
            <span id="maxScore">1345612</span>
        </div>
        <div class="col-sm-3 col-md-4"></div>
        <div class="gameBody col-sm-6 col-md-4" id="gameBody">
            <div class="row">
                <div class="item emptyItem x0y0" x="0" y="0"></div>
                <div class="item emptyItem x0y1" x="0" y="1"></div>
                <div class="item emptyItem x0y2" x="0" y="2"></div>
                <div class="item emptyItem x0y3" x="0" y="3"></div>
            </div>
            <div class="row">
                <div class="item emptyItem x1y0" x="1" y="0"></div>
                <div class="item emptyItem x1y1" x="1" y="1"></div>
                <div class="item emptyItem x1y2" x="1" y="2"></div>
                <div class="item emptyItem x1y3" x="1" y="3"></div>
            </div>
            <div class="row">
                <div class="item emptyItem x2y0" x="2" y="0"></div>
                <div class="item emptyItem x2y1" x="2" y="1"></div>
                <div class="item emptyItem x2y2" x="2" y="2"></div>
                <div class="item emptyItem x2y3" x="2" y="3"></div>
            </div>
            <div class="row">
                <div class="item emptyItem x3y0" x="3" y="0"></div>
                <div class="item emptyItem x3y1" x="3" y="1"></div>
                <div class="item emptyItem x3y2" x="3" y="2"></div>
                <div class="item emptyItem x3y3" x="3" y="3"></div>
            </div>
        </div>
        <div class="gameRule col-sm-12 col-md-12">电脑：请用键盘的方向键进行操作</div>
        <div class="gameRule col-sm-12 col-md-12">手机：请划动屏幕进行操作</div>
        <div class="col-sm-4 col-md-4"></div>
        <div class="scoreAndRefresh col-sm-6 col-md-6">
            <div class="gameScore ">得分：<span id="gameScore">0</span> 分</div>
            <button type="button" class="btn btn-danger refreshBtn">
                <span class="">刷新</span>
            </button>
        </div>
        <div class="col-sm-12 col-md-12" style="line-height: 40px">
            源代码：<a href="https://github.com/nnngu/js_game_2048"
                   target="_blank">https://github.com/nnngu/js_game_2048</a>
        </div>

        <div class="modal fade" id="gameOverModal" aria-labelledby="myModalLabel" aria-hidden="true"
             data-backdrop="static">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            ×
                        </button>
                        <h4 class="modal-tittle" id="myModalLabel">2048小游戏</h4>
                    </div>
                    <div class="modal-body">
                        Game Over!
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-danger refreshBtn" onclick="refreshGame()">再玩一次</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>