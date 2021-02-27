package com.yinghua.jilijili.bean;

import java.util.List;


/**
 * 新闻bean对象
 *
 * */
public class Journalism {


    private String code;
    private boolean charge;
    private String msg;
    private ResultDTOX result;
    private String requestId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultDTOX getResult() {
        return result;
    }

    public void setResult(ResultDTOX result) {
        this.result = result;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public static class ResultDTOX {
        private int status;
        private String msg;
        private ResultDTO result;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public ResultDTO getResult() {
            return result;
        }

        public void setResult(ResultDTO result) {
            this.result = result;
        }

        public static class ResultDTO {
            private String channel;
            private int num;
            private List<ListDTO> list;

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public List<ListDTO> getList() {
                return list;
            }

            public void setList(List<ListDTO> list) {
                this.list = list;
            }

            public static class ListDTO {
                private String title;
                private String time;
                private String src;
                private String category;
                private String pic;
                private String content;
                private String url;
                private String weburl;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public String getCategory() {
                    return category;
                }

                public void setCategory(String category) {
                    this.category = category;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWeburl() {
                    return weburl;
                }

                public void setWeburl(String weburl) {
                    this.weburl = weburl;
                }
            }
        }
    }
}
