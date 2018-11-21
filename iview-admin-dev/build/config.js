import Env from './env';

let config = {
    env: Env
};
export default config;


/*
import env from './env';

//修改DEV_URL为当前前端网站的地址
const DEV_URL = 'http://127.0.0.1:80/';

const PRO_URL = 'https://produce.com';

export default env === 'development' ? DEV_URL : PRO_URL

module.exports = {

    baseUrl: 'http://127.0.0.1:8080', // remote后台地址

    chainWebpack: config => {
        config.resolve.alias
            .set('@', resolve('src'))
            .set('_c', resolve('src/components'))
            .set('_conf', resolve('config'))
    },

    productionSourceMap: false,

    //设置跨域代理
    devServer: {
        historyApiFallback: true,
        hot: true,
        inline: true,
        stats: { colors: true },
        proxy: {
            //匹配代理的url
            '/api': {
                // 目标服务器地址
                target: 'http://127.0.0.1:8080',
                //路径重写
                pathRewrite: {'^/api' : '/'},
                changeOrigin: true
            }
        }
    }
}
*/
