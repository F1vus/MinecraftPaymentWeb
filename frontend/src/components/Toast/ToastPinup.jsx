

function ToastPinup() {

    return (
        <div>
            {/* Toast container */}
            <div className="toast-container position-fixed bottom-0 end-0 p-3">
                <div
                    id="liveToast"
                    className="toast"
                    role="alert"
                    aria-live="assertive"
                    aria-atomic="true"
                >
                    <div className="toast-header">
                        <strong className="me-auto">Error!</strong>
                        <button
                            type="button"
                            className="btn-close"
                            data-bs-dismiss="toast"
                            aria-label="Close"
                        ></button>
                    </div>
                    <div className="toast-body alert alert-danger">
                        The username or password cannot be empty
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ToastPinup;