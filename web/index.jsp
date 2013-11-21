<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>Justified Nav Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-lg-8">
            <img src="image/logo.png">
        </div>
        <div class="col-lg-3 pull-right">
            <div class="nav-search">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="关键字...">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button">搜索</button>
                        </span>
                </div>
            </div>
        </div>
    </div>
    <div class="masthead">
        <ul class="nav nav-justified">
            <li class="active"><a href="#">首页</a></li>
            <li><a href="#">电影</a></li>
            <li><a href="#">游戏</a></li>
            <li><a href="#">软件</a></li>
            <li><a href="#">Android专区</a></li>
            <li><a href="#">IOS专区</a></li>
        </ul>
    </div>

    <!-- Jumbotron -->
    <div class="jumbotron">
        <h1>资源共享计划</h1>
        <p class="lead">我们把观滔用户下载最热门的，最新的资源转换成内网资源供您使用。</p>
        <p><a class="btn btn-lg btn-success" href="#" role="button">有疑问？点这里</a></p>
    </div>

    <!-- Example row of columns -->
    <div class="row">
        <div class="col-lg-4">
            <div class="panel panel-danger">
                <div class="panel-heading">
                    <h3 class="panel-title">热门电影资源</h3>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">Cras justo odio</li>
                    <li class="list-group-item">Dapibus ac facilisis in</li>
                    <li class="list-group-item">Morbi leo risus</li>
                    <li class="list-group-item">Porta ac consectetur ac</li>
                    <li class="list-group-item">Vestibulum at eros</li>
                    <li class="list-group-item" style="text-align: right"><a href="#">更多...</a> </li>
                </ul>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">热门游戏资源</h3>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">Cras justo odio</li>
                    <li class="list-group-item">Dapibus ac facilisis in</li>
                    <li class="list-group-item">Morbi leo risus</li>
                    <li class="list-group-item">Porta ac consectetur ac</li>
                    <li class="list-group-item">Vestibulum at eros</li>
                    <li class="list-group-item" style="text-align: right"><a href="#">更多...</a> </li>
                </ul>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">热门软件资源</h3>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">Cras justo odio</li>
                    <li class="list-group-item">Dapibus ac facilisis in</li>
                    <li class="list-group-item">Morbi leo risus</li>
                    <li class="list-group-item">Porta ac consectetur ac</li>
                    <li class="list-group-item">Vestibulum at eros</li>
                    <li class="list-group-item" style="text-align: right"><a href="#">更多...</a> </li>
                </ul>
            </div>
        </div>
    </div>

    <!-- Site footer -->
    <div class="footer">
        <p>GuanTao &copy; High Tech 2013.</p>
    </div>

</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery-1.8.3.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
