<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- HEADER INCLUSION CODE -->

<jsp:include page="include/header.jsp"></jsp:include>

<!-- HEADER INCLUSION CODE -->

<body>
	<c:forEach var="postItems" items="${postValue}">
		<div id="wrap" class="grid_1200">
			<section class="container main-content">
				<div class="row">
					<div class="col-md-12">
						<article class="post single-post clearfix">
							<div class="post-inner">
								<div class="post-img">
									<a href="single_post.html"><img
										src="../ask-me/images/demo/posts/loneliness-1440x900.jpg"
										alt=""></a>
								</div>
								<h2 class="post-title">
									<span class="post-type"><i class="icon-film"></i></span>${postItems.title}</h2>
								<div class="post-meta">
									<span class="meta-date"> </span> <span>${postItems.postedDate}</span>


								</div>
								<div class="post-content">
									<p>${postItems.description}</p>

								</div>
								<!-- End post-content -->
								<div class="clearfix"></div>
							</div>
							<!-- End post-inner -->
						</article>
						<!-- End article.post -->
					</div>
					<!-- End row -->
				</div>
			</section>
			<!-- End container -->

		</div>
		<!-- End wrap -->

	</c:forEach>
	<!-- FOOTER INCLUSION CODE -->

	<jsp:include page="include/footer.jsp"></jsp:include>

	<!-- FOOTER INCLUSION CODE -->

	<!-- SCRIPT INCLUSION CODE -->

	<jsp:include page="include/script.jsp"></jsp:include>

	<!-- SCRIPT INCLUSION CODE -->