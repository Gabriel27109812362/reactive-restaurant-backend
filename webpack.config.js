const webpack = require('webpack');
const path = require('path');

module.exports = {
   entry: './src/index.js',
   mode: 'production',
   target: 'node',
   output: {
      path: path.resolve(__dirname, 'build'),
      filename: 'index.js',
   },
   resolve: {
      modules: ['src', 'node_modules'],
      alias: {
         controllers: path.resolve(__dirname, 'src/controllers'),
      },
      extensions: ['.js'],

   },
   plugins: [
      new webpack.DefinePlugin({
         'process.env': {
            'APP_PORT': JSON.stringify('3000'),
         },
      }),
   ],
};


