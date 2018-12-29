<%@ page pageEncoding="GB18030" %>

<div class="modal fade" tabindex="-1" role="dialog" id="loginModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="exampleModalLabel">µÇÂ¼</h4>
            </div>
            <div class="modal-body">
                <div class="modal-form">
                    <form action="/user/login" method="post">
                        <div class="form-group">
                            <label for="username" class="control-label">ÓÃ»§Ãû</label>
                            <input type="text" class="form-control" id="username" name="username" path="username">
                        </div>
                        <div class="form-group">
                            <label for="username" class="control-label">ÃÜÂë</label>
                            <input type="password" class="form-control" id="password" name="password" path="password">
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-success" value="µÇÂ¼">
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
