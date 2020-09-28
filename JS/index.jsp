<%@ page  contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="CSS/style.css">
  <link rel="stylesheet" href="CSS/bootstrap.min.css" />
  <link rel="stylesheet" href="CSS/1.css" />
  <title>白垩纪公园盒子 </title>
    <link rel="stylesheet" href="CSS/animate.css" />
    <link type="text/css" rel="stylesheet" href="CSS/carousel.css">
    <style type="text/css">
        *{
            padding: 0;
            margin: 0;
        }
        img{
            width:350px;
            height: 400px;
        }
        body{ background-color: #313131; }
        @keyframes fn{
            0% {transform:rotateX(-15deg) rotateY(0deg);}
            100%{transform:rotateX(-15deg) rotateY(360deg);}

        }
        @-moz-keyframes fn{
            0% {transform:rotateX(-15deg) rotateY(0deg);}
            100%{transform:rotateX(-15deg) rotateY(360deg);}
        }
        @-ms-keyframes fn{
            0% {transform:rotateX(-15deg) rotateY(0deg);}
            100%{transform:rotateX(-15deg) rotateY(360deg);}
        }
        @-webkit-keyframes fn{
            0% {transform:rotateX(-15deg) rotateY(0deg);}
            100%{transform:rotateX(-15deg) rotateY(360deg);}
        }
        .box{
            width:200px;
            height:300px;
            position:relative;
            margin:auto;
            margin-top:220px;
            left: 400px;
            transform-style:preserve-3d;
            transform:rotateX(-10deg);
            animation: fn 20s;
            animation-iteration-count: infinite;
            animation-timing-function: linear;
            position: relative
        }
        .box:hover{
            animation-play-state: paused;
        }
        .box>div{
            width:200px;
            height:300px;
            position: absolute;
            left:0;
            top:0;
        }
    </style>
</head>


<body>
<jsp:include page="JS/back_Top.jsp" flush="true" />

<div class="lunbo2 " style="padding:50px;">
    <div class="ziliao col-md-6">
        <div class="zixun1">
            <ul>
                <li><img src="images/konlon9.jpg" style="width: 200px;height: 150px;padding: 10px;" class="q234 col-md-4 wow fadeInLeftBig" data-wow-duration="1.5s" data-wow-delay="0s"/></li>
                <div class="q123 col-md-8 wow fadeInLeftBig" data-wow-duration="1.5s" data-wow-delay="0.3s" style="top: 20px;">
                    <p>霸王龙属暴龙科中体型最大的一种。体长约11.5-14.7米。最高臀高可达到5.2米左右，头高最高近6米。平均体重约9吨，(生态平均约7.6吨)，最重14.85吨，头部长度最大约1.55米。咬合力一般9万牛顿—12万牛顿，嘴巴末端最大可达20万牛顿左右，同时也是体型最为粗壮的食肉恐龙。</p>
                </div>
                <li><img src="images/konlon10.jpg" style="width: 200px;height: 150px;padding: 10px;"class="q234 col-md-4 wow fadeInRightBig" data-wow-duration="1.5s" data-wow-delay="0.5s"/></li>
                <div class="q123 col-md-8 wow fadeInRightBig" data-wow-duration="1.5s" data-wow-delay="0.8s" style="top: 15px;">
                    <p>沧龙（Mosasaurus），中生代海洋中最大的顶级掠食者。虽然它的历史很短（从陆地上的崖蜥进化而来，在白垩纪中晚期才出现并且迅速繁衍，随后和恐龙一起灭绝），但却一路乘风破浪，把比它历史早远得多的上龙类赶尽杀绝。</p>
                </div>
            </ul>
        </div>
        <div class="zxshipin">
            <p style="font-size: 30px;color: #AE1C1C;" class="wow flipInX" data-wow-duration="5s" data-wow-delay="1s">是投降？还是比敌人更强！</p>
            <video width="500px" height="350px"  loop="loop" autoplay="autoplay" muted controls="controls" >
                <source src="movie/4.mp4" type="video/mp4">
            </video>
        </div>
    </div>
    <div class="box col-md-6">
        <div style="transform: rotateY(0deg) translateZ(275px);">
            <img src="images/k1.jpg" >
        </div>
        <div style="transform: rotateY(40deg) translateZ(275px);">
            <img src="images/k2.jpg">
        </div>
        <div style="transform: rotateY(80deg) translateZ(275px);">
            <img src="images/k3.jpg">
        </div>
        <div style="transform: rotateY(120deg) translateZ(275px);">
            <img src="images/k4.jpg">
        </div>
        <div style="transform: rotateY(160deg) translateZ(275px);">
            <img src="images/k5.jpg">
        </div>
        <div style="transform: rotateY(200deg) translateZ(275px);">
            <img src="images/k6.jpg">
        </div>
        <div style="transform: rotateY(240deg) translateZ(275px);">
            <img src="images/k7.jpg">
        </div>
        <div style="transform: rotateY(280deg) translateZ(275px);">
            <img src="images/k8.jpg">
        </div>
        <div style="transform: rotateY(320deg) translateZ(275px);">
            <img src="images/k9.jpg" >
        </div>
    </div>
</div>
<jsp:include page="JS/back_Down.jsp" flush="true" />

</body>
</html>
<script type="text/javascript " src="JS/wow.min.js "></script>
<script>
    new WOW().init();
</script>