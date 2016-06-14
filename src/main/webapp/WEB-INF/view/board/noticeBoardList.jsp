<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1><i class="fa fa-map-marker">{{title}}</i></h1>
      <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-xs-12 col-sm-9">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
          <div class="row">
            <div class="col-xs-6 col-lg-4 col-sm-offset-1" data-ng-repeat="recommand in recommandLists">
              <h3><a style="text-decoration: none; color: black;" href="#/recommandDetail/{{recommand.listNo}}">{{recommand.title}}</a></h3>
              <p><img alt="" src="../../img/{{recommand.picture}}" width="200" height="200"></p>
            </div><!--/.col-xs-6.col-lg-4-->
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->
      </div><!--/row-->
<div data-uib-pagination 
							data-total-items="paging.totalItem" style="width:800px;" 
							data-ng-model="pageNo"
							data-max-size="10"
							data-ng-change="selectPage()"
							data-boundary-links="true">
						</div>
<div><a data-ng-show="c()" href="#/recommandInsert" class="btn btn-primary">글쓰기</a></div>
<hr>	

</body>
</html>