<%@ page pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Video Details</title>
<link href="views/css/Home.css" rel="stylesheet" />
<link href="views/css/detail.css" rel="stylesheet" />

</head>
<body>
	<%@ include file="/common/header.jsp"%>
	<h3 style="text-align: center;">Details Video</h3>
	<br>
	<div class="containers">
		<div class="videoseen">
			<p class="namevideo">${video.title}</p>
			<iframe width="853" height="480"
				src="https://www.youtube.com/embed/${video.link}"
				title="YouTube video player" frameborder="0"
				allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
				allowfullscreen></iframe>
			<p class="views">Mô tả :</p>
			<div class="fb-like" data-href="http://127.0.0.1:5500/index.html"
				data-width="" data-layout="button" data-action="like"
				data-size="small" data-share="true"></div>
			<h2>Đây là 1 số chi tiết : ${video.description}</h2>
		</div>
	</div>

	<c:forEach items="${videolst}" var="i">
		<c:if test="${i.id!=video.id}">
		<a href="<c:url value='/video?action=watch&id=${i.link}'/>" style="text-decoration:none;">
			<div class="sidenar">
				<div class="showdetails">
					<p class="namevideo">${i.title}</p>
					<iframe width="300" height="200" 
						src="https://www.youtube.com/embed/${i.link}"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
					<p class="views">Mô tả : ${i.description}</p>
					<div class="fb-like" data-href="http://127.0.0.1:5500/index.html"
						data-width="" data-layout="button" data-action="like"
						data-size="small" data-share="true"></div>
				</div>
			</div>
			</a>
		</c:if>
	</c:forEach>










	<section id="app">
		<div class="container">
			<div class="row">
				<div class="col-6">
					<div class="comment">
						
					</div>
					<!--End Comment-->
				</div>
				<!--End col -->
			</div>
			<!-- End row -->
			<div class="row">
				<div class="col-6">
					<h4>Add Your Comments:</h4>
					<textarea type="text" class="input" placeholder="Write a comment"
						v-model="newItem" @keyup.enter="addItem()"></textarea>
					<button v-on:click="addItem()" class='primaryContained float-right'
						type="submit">Add Comment</button>
				</div>
			
				<!-- End col -->
			</div>
			<!--End Row -->
		</div>
		<!--End Container -->
	</section>

	<%@ include file="/common/footer.jsp"%>

	<div id="fb-root"></div>
	<script async defer crossorigin="anonymous"
		src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v12.0&appId=1117863175398213&autoLogAppEvents=1"
		nonce="YiilOihb"></script>

</body>
</html>