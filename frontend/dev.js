
const htmlWebpackPlugin = require('html-webpack-plugin');
const CopyPlugin = require("copy-webpack-plugin");
const HtmlWebpackPlugin = require("html-webpack-plugin");

const generateHtmlPlugin = (title) => {
  return new htmlWebpackPlugin({
    title,
    filename: 'index.html',
    template: `./src/pages/${title.toLowerCase()}/index.html`,
  });
}

const populateHtmlPlugins = (pagesArray) => {
  res = [];
  pagesArray.forEach(page => {
    res.push(generateHtmlPlugin(page));
  })
  return res;
}

const pages = populateHtmlPlugins(["main","login"]);

module.exports = {
  module: {
    rules: [
      {
        test: /\.css$/,
        use: [
          { loader: "style-loader", options: { injectType: "styleTag" } },
          "css-loader",
        ],
      },

    ],
  },
  devServer: {
    port: 9000,
    watchFiles: {
      paths: ['src/**'],
      options: {
        usePolling: false,
      },

    },
    proxy: [{
      context: ['/api/**'],
      target: "http://localhost:8080/",
      changeOrigin: true,
    }]
  },
  mode: 'development',
  plugins: [
  new HtmlWebpackPlugin({
    template: './src/index.html',
    filename:'./index.html',
    chunks:["main"]
  }),
  new HtmlWebpackPlugin({
    template: './src/login.html',
    filename:'./login.html',
    chunks:["login"]
  }),
  new CopyPlugin({
    patterns: [
      { from: "assets", to: "assets" }
    ]}),
]
};

//https://stackoverflow.com/questions/60021318/what-is-the-right-way-to-configure-multiple-pages-in-webpack




