<%@page import="com.application.model.Comment"%>
<%@page import="java.util.List"%>
<%@page import="java.time.Period"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form"%>
<!-- HEADER FILE INCLUSION -->
<jsp:include page="include/header.jsp"></jsp:include>
<!-- HEADER FILE INCLUSION -->


<div class="breadcrumbs">
	<section class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>${post.title}</h1>
			</div>
			<div class="col-md-12">
				<div class="crumbs">
					<a href="#">Home</a> <span class="crumbs-span">/</span> <a href="#">Questions</a>
					<span class="crumbs-span">/</span> <span class="current">
						${post.title} </span>
				</div>
			</div>
		</div>
		<!-- End row -->
	</section>
	<!-- End container -->
</div>
<!-- End breadcrumbs -->
								
<section class="container main-content">
								
	<div class="row">
		<div class="col-md-12">
			<article class="question single-question question-type-normal">
				<h2>
					<a href="single_question.html"> ${post.title} </a>
				</h2>
				<div class="question-inner">
					<div class="clearfix"></div>
					<div class="question-desc">
						<p>${post.description}</p>
					</div>
					<span class="question-category"><a href="#"><i
							class="icon-folder-close"></i>${post.category}</a></span> <span
						class="question-date"><i class="icon-time"></i>
						<c:set
							var="postDate" value="${post.postedDate}" /> <%
			 	LocalDate now1 = LocalDate.now();
			 	Period time1 = Period.between((LocalDate) pageContext.getAttribute("postDate"), now1);
			 	out.print(time1.getDays() + " Days ago");
			 %></span> <span class="question-comment">
 						<a href="#"><i
							class="icon-comment"></i> <c:set var="i" value="0" /> 
							<%
							int i = 0;
							%>
							<c:forEach items="${post.comments}" var="comment">
								<%
									//pageContext.setAttribute("i", (Integer.parseInt((String) pageContext.getAttribute("i")) + 1));
									i++;
								%>
							</c:forEach> <%=i %> </a>
							<a class="question-report" href="updatepost?s=${post.id}">Update</a>
							<a class="" href="#">Delete</a>
							</span>
							
<!-- Add Comment button here -->
						 
					<div class="clearfix"></div>
				</div>
			</article>
			<!-- End share-tags -->
			<div id="commentlist" class="page-content">
				<div class="boxedtitle page-title">
					<h2>
						Answers ( <span class="color"><%=i %></span> )
					</h2>
				</div>
				<ol class="commentlist clearfix">
					<c:forEach items="${post.comments}" var="comment">
						<li class="comment">
							<div class="comment-body clearfix">
								<div class="avatar">
									<img alt="" src="images/demo/avatar.png">
								</div>
								<div class="comment-text">
									<div class="author clearfix">
										<div class="comment-author">
											<a href="#"> ${comment.email} </a>
										</div>
										<div class="comment-meta">
											<div class="date">
												<i class="icon-time"></i>
												<!--  ${comment.postedDate}  -->
												<c:set var="commentDate" value="${comment.postedDate}" />
												<%
													LocalDate now = LocalDate.now();
														Period time = Period.between((LocalDate) pageContext.getAttribute("commentDate"), now);
														out.print(time.getDays() + " Days ago");
												%>
											</div>
										</div>
									</div>
									<div class="text">
										<p>${comment.comment}</p>
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ol>
				<!-- End commentlist -->
			</div>
			<!-- End page-content -->

			<div id="respond" class="comment-respond page-content clearfix">
				<div class="boxedtitle page-title">
					<h2>Leave a reply</h2>
				</div>
				<forms:form modelAttribute="commentform" action="" method="post">
					<div id="respond-textarea">
						<p>
							<label class="required" for="comment">Comment<span>*</span></label>
							<forms:input type="text" path="comment" />
						</p>
					</div>
					<p class="form-submit">
						<input name="submit" type="submit" id="submit"
							value="Post your answer" class="button small color">
					</p>
				</forms:form>
			</div>
			<!-- End post-next-prev -->
		</div>
		<!-- End main -->
	</div>
	<!-- End row -->
</section>
<!-- End container -->
<br>
<br>



<!-- FOOTER FILE INCLUSION -->
<jsp:include page="include/footer.jsp"></jsp:include>
<!-- FOOTER FILE INCLUSION -->


<!-- SCRIPT FILE INCLUSION -->
<jsp:include page="include/script.jsp"></jsp:include>
<!-- SCRIPT FILE INCLUSION -->