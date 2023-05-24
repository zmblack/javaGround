import request from '@/utils/request'

// 查询单词本列表
export function listBook(query) {
  return request({
    url: '/my/book/list',
    method: 'get',
    params: query
  })
}

// 查询单词本详细
export function getBook(id) {
  return request({
    url: '/my/book/' + id,
    method: 'get'
  })
}

// 新增单词本
export function addBook(data) {
  return request({
    url: '/my/book',
    method: 'post',
    data: data
  })
}

// 修改单词本
export function updateBook(data) {
  return request({
    url: '/my/book',
    method: 'put',
    data: data
  })
}

// 删除单词本
export function delBook(id) {
  return request({
    url: '/my/book/' + id,
    method: 'delete'
  })
}


