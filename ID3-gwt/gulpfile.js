/**
 * @author sp
 */
const gulp = require('gulp'),
    babel = require('gulp-babel'),
    plumber = require('gulp-plumber'),
    terser = require('gulp-terser'),
    concat = require('gulp-concat'),
    del = require('del'),
    sass = require('gulp-sass'),
    autoprefixer = require('gulp-autoprefixer'),
    sourcemaps = require('gulp-sourcemaps');

gulp.task('compile:sass', function() {
    del([
        './target/sp-1.0.0/assets/style/app.css',
        './target/sp-1.0.0/assets/style/app.css.map'
    ]);
    return gulp.src('./src/main/assets/style/**/*.scss')
        .pipe(sourcemaps.init())
        .pipe(sass({
            outputStyle: 'compressed'
        }).on('error', sass.logError))
        .pipe(autoprefixer({
            cascade: false,
            grid: 'autoplace'
        }))
        .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest('./target/sp-1.0.0/assets/style'))
});

/* sass watcher task */
gulp.task('watch:sass', function () {
	gulp.watch('./src/main/assets/style/**/*.scss', ['compile:sass']);
});

/* default task */
gulp.task('default', ['compile:sass']);